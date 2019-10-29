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
    public static final int cAW = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private a cAU;
    private TextView cAX;
    private TbImageView cAY;
    private View cAZ;
    private TbImageView cBa;
    private boolean cBb;
    private AgreeView cqp;
    private TextView cqq;
    private ImageUrlData czt;
    private String mUserId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.cAU = null;
        this.cBb = true;
        init(context);
        initListener();
    }

    public ImageViewerBottomLayout(Context context, boolean z) {
        super(context);
        this.cAU = null;
        this.cBb = true;
        this.cBb = z;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.cAZ = findViewById(R.id.unfold_root);
        this.cAX = (TextView) findViewById(R.id.unfold_text);
        this.cAY = (TbImageView) findViewById(R.id.unfold_icon);
        this.cAZ.setVisibility(8);
        am.setImageResource(this.cAY, R.drawable.icon_picture_unfold_white_n);
        this.cBa = (TbImageView) findViewById(R.id.comment_icon);
        am.setImageResource(this.cBa, R.drawable.icon_picture_comment_white_n);
        this.cqq = (TextView) findViewById(R.id.comment_num);
        this.cqq.setText("0");
        this.cqp = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.cqp.setIsFromBigpic(true);
        this.cqp.setAgreeAnimationResource(R.raw.agree_bigpic);
        this.cqp.setDisagreeAnimationResource(R.raw.disagree_bigpic);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bXQ = 13;
        dVar.bXV = 10;
        this.cqp.setStatisticData(dVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.cAU = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.czt = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.cqq.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.cqp.setData(imageUrlData.agreeData);
            }
            if (!this.cBb) {
                this.cAZ.setVisibility(4);
                return;
            } else if (TextUtils.isEmpty(imageUrlData.richTextArray) || "[]".equals(imageUrlData.richTextArray)) {
                this.cAZ.setVisibility(4);
                return;
            } else {
                this.cAZ.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.cBa.setOnClickListener(this);
        this.cqq.setOnClickListener(this);
        this.cAZ.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void eR(boolean z) {
        if (z) {
            this.cAX.setText(getContext().getString(R.string.expand));
            am.setImageResource(this.cAY, R.drawable.icon_picture_packup_white_n);
            return;
        }
        this.cAX.setText(getContext().getString(R.string.fold));
        am.setImageResource(this.cAY, R.drawable.icon_picture_unfold_white_n);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cBa || view == this.cqq) {
            TiebaStatic.log(new an("c12942").bS("obj_type", "2").bS("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
            asj();
        } else if (view == this.cAZ) {
            if (this.cAX.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.cAX.setText(getContext().getString(R.string.fold));
                am.setImageResource(this.cAY, R.drawable.icon_picture_unfold_white_n);
                if (this.cAU != null) {
                    this.cAU.a(this, true);
                    return;
                }
                return;
            }
            this.cAX.setText(getContext().getString(R.string.expand));
            am.setImageResource(this.cAY, R.drawable.icon_picture_packup_white_n);
            if (this.cAU != null) {
                this.cAU.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new an("c13339").bS("uid", this.mUserId).p("post_id", this.czt.threadId));
        return true;
    }

    private void asj() {
        if (this.czt != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.czt.threadId), String.valueOf(this.czt.postId), this.czt.mIsSeeHost, this.czt.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
