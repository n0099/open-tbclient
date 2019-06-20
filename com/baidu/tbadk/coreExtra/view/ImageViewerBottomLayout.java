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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static final int clL = l.g(TbadkApplication.getInst(), R.dimen.tbds130);
    private AgreeView bZZ;
    private TextView caa;
    private ImageUrlData ckf;
    private a clJ;
    private TextView clM;
    private TbImageView clN;
    private View clO;
    private TbImageView clP;
    private boolean clQ;
    private String mUserId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.clJ = null;
        this.clQ = true;
        init(context);
        initListener();
    }

    public ImageViewerBottomLayout(Context context, boolean z) {
        super(context);
        this.clJ = null;
        this.clQ = true;
        this.clQ = z;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.clO = findViewById(R.id.unfold_root);
        this.clM = (TextView) findViewById(R.id.unfold_text);
        this.clN = (TbImageView) findViewById(R.id.unfold_icon);
        this.clO.setVisibility(8);
        al.c(this.clN, (int) R.drawable.icon_picture_unfold_white_n);
        this.clP = (TbImageView) findViewById(R.id.comment_icon);
        al.c(this.clP, (int) R.drawable.icon_picture_comment_white_n);
        this.caa = (TextView) findViewById(R.id.comment_num);
        this.caa.setText("0");
        this.bZZ = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.bZZ.setIsFromBigpic(true);
        this.bZZ.setAgreeAnimationResource(R.raw.agree_bigpic);
        this.bZZ.setDisagreeAnimationResource(R.raw.disagree_bigpic);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bEz = 13;
        dVar.bEE = 10;
        this.bZZ.setStatisticData(dVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.clJ = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.ckf = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.caa.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.bZZ.setData(imageUrlData.agreeData);
            }
            if (!this.clQ) {
                this.clO.setVisibility(4);
                return;
            } else if (TextUtils.isEmpty(imageUrlData.richTextArray) || "[]".equals(imageUrlData.richTextArray)) {
                this.clO.setVisibility(4);
                return;
            } else {
                this.clO.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.clP.setOnClickListener(this);
        this.caa.setOnClickListener(this);
        this.clO.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void eP(boolean z) {
        if (z) {
            this.clM.setText(getContext().getString(R.string.expand));
            al.c(this.clN, (int) R.drawable.icon_picture_packup_white_n);
            return;
        }
        this.clM.setText(getContext().getString(R.string.fold));
        al.c(this.clN, (int) R.drawable.icon_picture_unfold_white_n);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.clP || view == this.caa) {
            TiebaStatic.log(new am("c12942").bT("obj_type", "2").bT("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
            aoV();
        } else if (view == this.clO) {
            if (this.clM.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.clM.setText(getContext().getString(R.string.fold));
                al.c(this.clN, (int) R.drawable.icon_picture_unfold_white_n);
                if (this.clJ != null) {
                    this.clJ.a(this, true);
                    return;
                }
                return;
            }
            this.clM.setText(getContext().getString(R.string.expand));
            al.c(this.clN, (int) R.drawable.icon_picture_packup_white_n);
            if (this.clJ != null) {
                this.clJ.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new am("c13339").bT("uid", this.mUserId).l("post_id", this.ckf.threadId));
        return true;
    }

    private void aoV() {
        if (this.ckf != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.ckf.threadId), String.valueOf(this.ckf.postId), this.ckf.mIsSeeHost, this.ckf.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createHistoryCfg));
        }
    }
}
