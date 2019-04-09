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
    public static final int cdF = l.h(TbadkApplication.getInst(), d.e.tbds130);
    private AgreeView bSg;
    private TextView bSh;
    private ImageUrlData cbZ;
    private a cdD;
    private TextView cdG;
    private TbImageView cdH;
    private View cdI;
    private TbImageView cdJ;
    private boolean cdK;
    private String mUserId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.cdD = null;
        this.cdK = true;
        init(context);
        initListener();
    }

    public ImageViewerBottomLayout(Context context, boolean z) {
        super(context);
        this.cdD = null;
        this.cdK = true;
        this.cdK = z;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.cdI = findViewById(d.g.unfold_root);
        this.cdG = (TextView) findViewById(d.g.unfold_text);
        this.cdH = (TbImageView) findViewById(d.g.unfold_icon);
        this.cdI.setVisibility(8);
        al.c(this.cdH, d.f.icon_picture_unfold_white_n);
        this.cdJ = (TbImageView) findViewById(d.g.comment_icon);
        al.c(this.cdJ, d.f.icon_picture_comment_white_n);
        this.bSh = (TextView) findViewById(d.g.comment_num);
        this.bSh.setText("0");
        this.bSg = (AgreeView) findViewById(d.g.agree_and_disagreeview);
        this.bSg.setIsFromBigpic(true);
        this.bSg.setAgreeAnimationResource(d.i.agree_bigpic);
        this.bSg.setDisagreeAnimationResource(d.i.disagree_bigpic);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bxn = 13;
        dVar.bxs = 10;
        this.bSg.setStatisticData(dVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.cdD = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.cbZ = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.bSh.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.bSg.setData(imageUrlData.agreeData);
            }
            if (!this.cdK) {
                this.cdI.setVisibility(4);
                return;
            } else if (TextUtils.isEmpty(imageUrlData.richTextArray)) {
                this.cdI.setVisibility(4);
                return;
            } else {
                this.cdI.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.cdJ.setOnClickListener(this);
        this.bSh.setOnClickListener(this);
        this.cdI.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void et(boolean z) {
        if (z) {
            this.cdG.setText(getContext().getString(d.j.expand));
            al.c(this.cdH, d.f.icon_picture_packup_white_n);
            return;
        }
        this.cdG.setText(getContext().getString(d.j.fold));
        al.c(this.cdH, d.f.icon_picture_unfold_white_n);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cdJ || view == this.bSh) {
            TiebaStatic.log(new am("c12942").bJ("obj_type", "2").bJ("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
            ajU();
        } else if (view == this.cdI) {
            if (this.cdG.getText().toString().equals(getContext().getString(d.j.expand))) {
                this.cdG.setText(getContext().getString(d.j.fold));
                al.c(this.cdH, d.f.icon_picture_unfold_white_n);
                if (this.cdD != null) {
                    this.cdD.a(this, true);
                    return;
                }
                return;
            }
            this.cdG.setText(getContext().getString(d.j.expand));
            al.c(this.cdH, d.f.icon_picture_packup_white_n);
            if (this.cdD != null) {
                this.cdD.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new am("c13339").bJ("uid", this.mUserId).k("post_id", this.cbZ.threadId));
        return true;
    }

    private void ajU() {
        if (this.cbZ != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.cbZ.threadId), String.valueOf(this.cbZ.postId), this.cbZ.mIsSeeHost, this.cbZ.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createHistoryCfg));
        }
    }
}
