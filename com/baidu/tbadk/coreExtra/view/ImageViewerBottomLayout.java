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
    public static final int cnf = l.g(TbadkApplication.getInst(), R.dimen.tbds130);
    private AgreeView cbi;
    private TextView cbj;
    private ImageUrlData cly;
    private a cnd;
    private TextView cng;
    private TbImageView cnh;
    private View cni;
    private TbImageView cnj;
    private boolean cnk;
    private String mUserId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.cnd = null;
        this.cnk = true;
        init(context);
        initListener();
    }

    public ImageViewerBottomLayout(Context context, boolean z) {
        super(context);
        this.cnd = null;
        this.cnk = true;
        this.cnk = z;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.cni = findViewById(R.id.unfold_root);
        this.cng = (TextView) findViewById(R.id.unfold_text);
        this.cnh = (TbImageView) findViewById(R.id.unfold_icon);
        this.cni.setVisibility(8);
        am.c(this.cnh, (int) R.drawable.icon_picture_unfold_white_n);
        this.cnj = (TbImageView) findViewById(R.id.comment_icon);
        am.c(this.cnj, (int) R.drawable.icon_picture_comment_white_n);
        this.cbj = (TextView) findViewById(R.id.comment_num);
        this.cbj.setText("0");
        this.cbi = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.cbi.setIsFromBigpic(true);
        this.cbi.setAgreeAnimationResource(R.raw.agree_bigpic);
        this.cbi.setDisagreeAnimationResource(R.raw.disagree_bigpic);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bFA = 13;
        dVar.bFF = 10;
        this.cbi.setStatisticData(dVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.cnd = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.cly = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.cbj.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.cbi.setData(imageUrlData.agreeData);
            }
            if (!this.cnk) {
                this.cni.setVisibility(4);
                return;
            } else if (TextUtils.isEmpty(imageUrlData.richTextArray) || "[]".equals(imageUrlData.richTextArray)) {
                this.cni.setVisibility(4);
                return;
            } else {
                this.cni.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.cnj.setOnClickListener(this);
        this.cbj.setOnClickListener(this);
        this.cni.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void eT(boolean z) {
        if (z) {
            this.cng.setText(getContext().getString(R.string.expand));
            am.c(this.cnh, (int) R.drawable.icon_picture_packup_white_n);
            return;
        }
        this.cng.setText(getContext().getString(R.string.fold));
        am.c(this.cnh, (int) R.drawable.icon_picture_unfold_white_n);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cnj || view == this.cbj) {
            TiebaStatic.log(new an("c12942").bT("obj_type", "2").bT("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
            aqd();
        } else if (view == this.cni) {
            if (this.cng.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.cng.setText(getContext().getString(R.string.fold));
                am.c(this.cnh, (int) R.drawable.icon_picture_unfold_white_n);
                if (this.cnd != null) {
                    this.cnd.a(this, true);
                    return;
                }
                return;
            }
            this.cng.setText(getContext().getString(R.string.expand));
            am.c(this.cnh, (int) R.drawable.icon_picture_packup_white_n);
            if (this.cnd != null) {
                this.cnd.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new an("c13339").bT("uid", this.mUserId).l("post_id", this.cly.threadId));
        return true;
    }

    private void aqd() {
        if (this.cly != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.cly.threadId), String.valueOf(this.cly.postId), this.cly.mIsSeeHost, this.cly.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createHistoryCfg));
        }
    }
}
