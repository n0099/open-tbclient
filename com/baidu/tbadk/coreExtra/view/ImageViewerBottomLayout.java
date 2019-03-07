package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
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
import com.baidu.tieba.d;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static final int cdC = l.h(TbadkApplication.getInst(), d.e.tbds130);
    private AgreeView bSc;
    private TextView bSd;
    private ImageUrlData cbW;
    private a cdA;
    private TextView cdD;
    private TbImageView cdE;
    private View cdF;
    private TbImageView cdG;
    private boolean cdH;
    private String mUserId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.cdA = null;
        this.cdH = true;
        init(context);
        initListener();
    }

    public ImageViewerBottomLayout(Context context, boolean z) {
        super(context);
        this.cdA = null;
        this.cdH = true;
        this.cdH = z;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.cdF = findViewById(d.g.unfold_root);
        this.cdD = (TextView) findViewById(d.g.unfold_text);
        this.cdE = (TbImageView) findViewById(d.g.unfold_icon);
        this.cdF.setVisibility(8);
        al.c(this.cdE, d.f.icon_picture_unfold_white_n);
        this.cdG = (TbImageView) findViewById(d.g.comment_icon);
        al.c(this.cdG, d.f.icon_picture_comment_white_n);
        this.bSd = (TextView) findViewById(d.g.comment_num);
        this.bSd.setText("0");
        this.bSc = (AgreeView) findViewById(d.g.agree_and_disagreeview);
        this.bSc.setIsFromBigpic(true);
        this.bSc.setAgreeAnimationResource(d.i.agree_bigpic);
        this.bSc.setDisagreeAnimationResource(d.i.disagree_bigpic);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bxh = 13;
        dVar.bxm = 10;
        this.bSc.setStatisticData(dVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.cdA = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.cbW = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.bSd.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.bSc.setData(imageUrlData.agreeData);
            }
            if (!this.cdH) {
                this.cdF.setVisibility(4);
                return;
            } else if (imageUrlData.richTextArray == null || imageUrlData.richTextArray.length() == 0) {
                this.cdF.setVisibility(4);
                return;
            } else {
                this.cdF.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.cdG.setOnClickListener(this);
        this.bSd.setOnClickListener(this);
        this.cdF.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void et(boolean z) {
        if (z) {
            this.cdD.setText(getContext().getString(d.j.expand));
            al.c(this.cdE, d.f.icon_picture_packup_white_n);
            return;
        }
        this.cdD.setText(getContext().getString(d.j.fold));
        al.c(this.cdE, d.f.icon_picture_unfold_white_n);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cdG || view == this.bSd) {
            TiebaStatic.log(new am("c12942").bJ("obj_type", "2").bJ("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
            ajY();
        } else if (view == this.cdF) {
            if (this.cdD.getText().toString().equals(getContext().getString(d.j.expand))) {
                this.cdD.setText(getContext().getString(d.j.fold));
                al.c(this.cdE, d.f.icon_picture_unfold_white_n);
                if (this.cdA != null) {
                    this.cdA.a(this, true);
                    return;
                }
                return;
            }
            this.cdD.setText(getContext().getString(d.j.expand));
            al.c(this.cdE, d.f.icon_picture_packup_white_n);
            if (this.cdA != null) {
                this.cdA.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new am("c13339").bJ("uid", this.mUserId).k("post_id", this.cbW.threadId));
        return true;
    }

    private void ajY() {
        if (this.cbW != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.cbW.threadId), String.valueOf(this.cbW.postId), this.cbW.mIsSeeHost, this.cbW.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createHistoryCfg));
        }
    }
}
