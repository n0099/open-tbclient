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
import com.baidu.tieba.d;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static final int cdE = l.h(TbadkApplication.getInst(), d.e.tbds130);
    private AgreeView bSf;
    private TextView bSg;
    private ImageUrlData cbY;
    private a cdC;
    private TextView cdF;
    private TbImageView cdG;
    private View cdH;
    private TbImageView cdI;
    private boolean cdJ;
    private String mUserId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.cdC = null;
        this.cdJ = true;
        init(context);
        initListener();
    }

    public ImageViewerBottomLayout(Context context, boolean z) {
        super(context);
        this.cdC = null;
        this.cdJ = true;
        this.cdJ = z;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.cdH = findViewById(d.g.unfold_root);
        this.cdF = (TextView) findViewById(d.g.unfold_text);
        this.cdG = (TbImageView) findViewById(d.g.unfold_icon);
        this.cdH.setVisibility(8);
        al.c(this.cdG, d.f.icon_picture_unfold_white_n);
        this.cdI = (TbImageView) findViewById(d.g.comment_icon);
        al.c(this.cdI, d.f.icon_picture_comment_white_n);
        this.bSg = (TextView) findViewById(d.g.comment_num);
        this.bSg.setText("0");
        this.bSf = (AgreeView) findViewById(d.g.agree_and_disagreeview);
        this.bSf.setIsFromBigpic(true);
        this.bSf.setAgreeAnimationResource(d.i.agree_bigpic);
        this.bSf.setDisagreeAnimationResource(d.i.disagree_bigpic);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bxm = 13;
        dVar.bxr = 10;
        this.bSf.setStatisticData(dVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.cdC = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.cbY = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.bSg.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.bSf.setData(imageUrlData.agreeData);
            }
            if (!this.cdJ) {
                this.cdH.setVisibility(4);
                return;
            } else if (TextUtils.isEmpty(imageUrlData.richTextArray)) {
                this.cdH.setVisibility(4);
                return;
            } else {
                this.cdH.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.cdI.setOnClickListener(this);
        this.bSg.setOnClickListener(this);
        this.cdH.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void et(boolean z) {
        if (z) {
            this.cdF.setText(getContext().getString(d.j.expand));
            al.c(this.cdG, d.f.icon_picture_packup_white_n);
            return;
        }
        this.cdF.setText(getContext().getString(d.j.fold));
        al.c(this.cdG, d.f.icon_picture_unfold_white_n);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cdI || view == this.bSg) {
            TiebaStatic.log(new am("c12942").bJ("obj_type", "2").bJ("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
            ajU();
        } else if (view == this.cdH) {
            if (this.cdF.getText().toString().equals(getContext().getString(d.j.expand))) {
                this.cdF.setText(getContext().getString(d.j.fold));
                al.c(this.cdG, d.f.icon_picture_unfold_white_n);
                if (this.cdC != null) {
                    this.cdC.a(this, true);
                    return;
                }
                return;
            }
            this.cdF.setText(getContext().getString(d.j.expand));
            al.c(this.cdG, d.f.icon_picture_packup_white_n);
            if (this.cdC != null) {
                this.cdC.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new am("c13339").bJ("uid", this.mUserId).k("post_id", this.cbY.threadId));
        return true;
    }

    private void ajU() {
        if (this.cbY != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.cbY.threadId), String.valueOf(this.cbY.postId), this.cbY.mIsSeeHost, this.cbY.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createHistoryCfg));
        }
    }
}
