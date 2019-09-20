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
    public static final int cob = l.g(TbadkApplication.getInst(), R.dimen.tbds130);
    private AgreeView ccb;
    private TextView ccc;
    private ImageUrlData cmu;
    private a cnZ;
    private TextView coc;
    private TbImageView cod;
    private View coe;
    private TbImageView cof;
    private boolean cog;
    private String mUserId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.cnZ = null;
        this.cog = true;
        init(context);
        initListener();
    }

    public ImageViewerBottomLayout(Context context, boolean z) {
        super(context);
        this.cnZ = null;
        this.cog = true;
        this.cog = z;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.coe = findViewById(R.id.unfold_root);
        this.coc = (TextView) findViewById(R.id.unfold_text);
        this.cod = (TbImageView) findViewById(R.id.unfold_icon);
        this.coe.setVisibility(8);
        am.c(this.cod, (int) R.drawable.icon_picture_unfold_white_n);
        this.cof = (TbImageView) findViewById(R.id.comment_icon);
        am.c(this.cof, (int) R.drawable.icon_picture_comment_white_n);
        this.ccc = (TextView) findViewById(R.id.comment_num);
        this.ccc.setText("0");
        this.ccb = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.ccb.setIsFromBigpic(true);
        this.ccb.setAgreeAnimationResource(R.raw.agree_bigpic);
        this.ccb.setDisagreeAnimationResource(R.raw.disagree_bigpic);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bFY = 13;
        dVar.bGd = 10;
        this.ccb.setStatisticData(dVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.cnZ = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.cmu = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.ccc.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.ccb.setData(imageUrlData.agreeData);
            }
            if (!this.cog) {
                this.coe.setVisibility(4);
                return;
            } else if (TextUtils.isEmpty(imageUrlData.richTextArray) || "[]".equals(imageUrlData.richTextArray)) {
                this.coe.setVisibility(4);
                return;
            } else {
                this.coe.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.cof.setOnClickListener(this);
        this.ccc.setOnClickListener(this);
        this.coe.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void eW(boolean z) {
        if (z) {
            this.coc.setText(getContext().getString(R.string.expand));
            am.c(this.cod, (int) R.drawable.icon_picture_packup_white_n);
            return;
        }
        this.coc.setText(getContext().getString(R.string.fold));
        am.c(this.cod, (int) R.drawable.icon_picture_unfold_white_n);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cof || view == this.ccc) {
            TiebaStatic.log(new an("c12942").bT("obj_type", "2").bT("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
            aqp();
        } else if (view == this.coe) {
            if (this.coc.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.coc.setText(getContext().getString(R.string.fold));
                am.c(this.cod, (int) R.drawable.icon_picture_unfold_white_n);
                if (this.cnZ != null) {
                    this.cnZ.a(this, true);
                    return;
                }
                return;
            }
            this.coc.setText(getContext().getString(R.string.expand));
            am.c(this.cod, (int) R.drawable.icon_picture_packup_white_n);
            if (this.cnZ != null) {
                this.cnZ.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new an("c13339").bT("uid", this.mUserId).n("post_id", this.cmu.threadId));
        return true;
    }

    private void aqp() {
        if (this.cmu != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.cmu.threadId), String.valueOf(this.cmu.postId), this.cmu.mIsSeeHost, this.cmu.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createHistoryCfg));
        }
    }
}
