package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static final int cAf = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private a cAd;
    private TextView cAg;
    private TbImageView cAh;
    private View cAi;
    private TbImageView cAj;
    private boolean cAk;
    private AgreeView cpy;
    private TextView cpz;
    private ImageUrlData cyC;
    private String mUserId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.cAd = null;
        this.cAk = true;
        init(context);
        initListener();
    }

    public ImageViewerBottomLayout(Context context, boolean z) {
        super(context);
        this.cAd = null;
        this.cAk = true;
        this.cAk = z;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.cAi = findViewById(R.id.unfold_root);
        this.cAg = (TextView) findViewById(R.id.unfold_text);
        this.cAh = (TbImageView) findViewById(R.id.unfold_icon);
        this.cAi.setVisibility(8);
        am.setImageResource(this.cAh, R.drawable.icon_picture_unfold_white_n);
        this.cAj = (TbImageView) findViewById(R.id.comment_icon);
        am.setImageResource(this.cAj, R.drawable.icon_picture_comment_white_n);
        this.cpz = (TextView) findViewById(R.id.comment_num);
        this.cpz.setText("0");
        this.cpy = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.cpy.setIsFromBigpic(true);
        this.cpy.setAgreeAnimationResource(R.raw.agree_bigpic);
        this.cpy.setDisagreeAnimationResource(R.raw.disagree_bigpic);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bWZ = 13;
        dVar.bXe = 10;
        this.cpy.setStatisticData(dVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.cAd = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.cyC = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.cpz.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.cpy.setData(imageUrlData.agreeData);
            }
            if (!this.cAk) {
                this.cAi.setVisibility(4);
                return;
            } else if (TextUtils.isEmpty(imageUrlData.richTextArray) || "[]".equals(imageUrlData.richTextArray)) {
                this.cAi.setVisibility(4);
                return;
            } else {
                this.cAi.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.cAj.setOnClickListener(this);
        this.cpz.setOnClickListener(this);
        this.cAi.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void eR(boolean z) {
        if (z) {
            this.cAg.setText(getContext().getString(R.string.expand));
            am.setImageResource(this.cAh, R.drawable.icon_picture_packup_white_n);
            return;
        }
        this.cAg.setText(getContext().getString(R.string.fold));
        am.setImageResource(this.cAh, R.drawable.icon_picture_unfold_white_n);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cAj || view == this.cpz) {
            TiebaStatic.log(new an("c12942").bS("obj_type", "2").bS("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
            ash();
        } else if (view == this.cAi) {
            if (this.cAg.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.cAg.setText(getContext().getString(R.string.fold));
                am.setImageResource(this.cAh, R.drawable.icon_picture_unfold_white_n);
                if (this.cAd != null) {
                    this.cAd.a(this, true);
                    return;
                }
                return;
            }
            this.cAg.setText(getContext().getString(R.string.expand));
            am.setImageResource(this.cAh, R.drawable.icon_picture_packup_white_n);
            if (this.cAd != null) {
                this.cAd.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new an("c13339").bS("uid", this.mUserId).p("post_id", this.cyC.threadId));
        return true;
    }

    private void ash() {
        if (this.cyC != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.cyC.threadId), String.valueOf(this.cyC.postId), this.cyC.mIsSeeHost, this.cyC.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
