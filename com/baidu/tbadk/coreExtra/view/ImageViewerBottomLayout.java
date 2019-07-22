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
    public static final int cmY = l.g(TbadkApplication.getInst(), R.dimen.tbds130);
    private AgreeView cbb;
    private TextView cbc;
    private ImageUrlData clr;
    private a cmW;
    private TextView cmZ;
    private TbImageView cna;
    private View cnb;
    private TbImageView cnc;
    private boolean cnd;
    private String mUserId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.cmW = null;
        this.cnd = true;
        init(context);
        initListener();
    }

    public ImageViewerBottomLayout(Context context, boolean z) {
        super(context);
        this.cmW = null;
        this.cnd = true;
        this.cnd = z;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.cnb = findViewById(R.id.unfold_root);
        this.cmZ = (TextView) findViewById(R.id.unfold_text);
        this.cna = (TbImageView) findViewById(R.id.unfold_icon);
        this.cnb.setVisibility(8);
        am.c(this.cna, (int) R.drawable.icon_picture_unfold_white_n);
        this.cnc = (TbImageView) findViewById(R.id.comment_icon);
        am.c(this.cnc, (int) R.drawable.icon_picture_comment_white_n);
        this.cbc = (TextView) findViewById(R.id.comment_num);
        this.cbc.setText("0");
        this.cbb = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.cbb.setIsFromBigpic(true);
        this.cbb.setAgreeAnimationResource(R.raw.agree_bigpic);
        this.cbb.setDisagreeAnimationResource(R.raw.disagree_bigpic);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bFz = 13;
        dVar.bFE = 10;
        this.cbb.setStatisticData(dVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.cmW = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.clr = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.cbc.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.cbb.setData(imageUrlData.agreeData);
            }
            if (!this.cnd) {
                this.cnb.setVisibility(4);
                return;
            } else if (TextUtils.isEmpty(imageUrlData.richTextArray) || "[]".equals(imageUrlData.richTextArray)) {
                this.cnb.setVisibility(4);
                return;
            } else {
                this.cnb.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.cnc.setOnClickListener(this);
        this.cbc.setOnClickListener(this);
        this.cnb.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void eT(boolean z) {
        if (z) {
            this.cmZ.setText(getContext().getString(R.string.expand));
            am.c(this.cna, (int) R.drawable.icon_picture_packup_white_n);
            return;
        }
        this.cmZ.setText(getContext().getString(R.string.fold));
        am.c(this.cna, (int) R.drawable.icon_picture_unfold_white_n);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cnc || view == this.cbc) {
            TiebaStatic.log(new an("c12942").bT("obj_type", "2").bT("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
            aqb();
        } else if (view == this.cnb) {
            if (this.cmZ.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.cmZ.setText(getContext().getString(R.string.fold));
                am.c(this.cna, (int) R.drawable.icon_picture_unfold_white_n);
                if (this.cmW != null) {
                    this.cmW.a(this, true);
                    return;
                }
                return;
            }
            this.cmZ.setText(getContext().getString(R.string.expand));
            am.c(this.cna, (int) R.drawable.icon_picture_packup_white_n);
            if (this.cmW != null) {
                this.cmW.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new an("c13339").bT("uid", this.mUserId).l("post_id", this.clr.threadId));
        return true;
    }

    private void aqb() {
        if (this.clr != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.clr.threadId), String.valueOf(this.clr.postId), this.clr.mIsSeeHost, this.clr.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createHistoryCfg));
        }
    }
}
