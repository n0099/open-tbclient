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
    public static final int clK = l.g(TbadkApplication.getInst(), R.dimen.tbds130);
    private AgreeView bZY;
    private TextView bZZ;
    private ImageUrlData cke;
    private a clI;
    private TextView clL;
    private TbImageView clM;
    private View clN;
    private TbImageView clO;
    private boolean clP;
    private String mUserId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.clI = null;
        this.clP = true;
        init(context);
        initListener();
    }

    public ImageViewerBottomLayout(Context context, boolean z) {
        super(context);
        this.clI = null;
        this.clP = true;
        this.clP = z;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.clN = findViewById(R.id.unfold_root);
        this.clL = (TextView) findViewById(R.id.unfold_text);
        this.clM = (TbImageView) findViewById(R.id.unfold_icon);
        this.clN.setVisibility(8);
        al.c(this.clM, (int) R.drawable.icon_picture_unfold_white_n);
        this.clO = (TbImageView) findViewById(R.id.comment_icon);
        al.c(this.clO, (int) R.drawable.icon_picture_comment_white_n);
        this.bZZ = (TextView) findViewById(R.id.comment_num);
        this.bZZ.setText("0");
        this.bZY = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.bZY.setIsFromBigpic(true);
        this.bZY.setAgreeAnimationResource(R.raw.agree_bigpic);
        this.bZY.setDisagreeAnimationResource(R.raw.disagree_bigpic);
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.bEy = 13;
        dVar.bED = 10;
        this.bZY.setStatisticData(dVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.clI = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.cke = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.bZZ.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.bZY.setData(imageUrlData.agreeData);
            }
            if (!this.clP) {
                this.clN.setVisibility(4);
                return;
            } else if (TextUtils.isEmpty(imageUrlData.richTextArray) || "[]".equals(imageUrlData.richTextArray)) {
                this.clN.setVisibility(4);
                return;
            } else {
                this.clN.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.clO.setOnClickListener(this);
        this.bZZ.setOnClickListener(this);
        this.clN.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void eP(boolean z) {
        if (z) {
            this.clL.setText(getContext().getString(R.string.expand));
            al.c(this.clM, (int) R.drawable.icon_picture_packup_white_n);
            return;
        }
        this.clL.setText(getContext().getString(R.string.fold));
        al.c(this.clM, (int) R.drawable.icon_picture_unfold_white_n);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.clO || view == this.bZZ) {
            TiebaStatic.log(new am("c12942").bT("obj_type", "2").bT("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
            aoV();
        } else if (view == this.clN) {
            if (this.clL.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.clL.setText(getContext().getString(R.string.fold));
                al.c(this.clM, (int) R.drawable.icon_picture_unfold_white_n);
                if (this.clI != null) {
                    this.clI.a(this, true);
                    return;
                }
                return;
            }
            this.clL.setText(getContext().getString(R.string.expand));
            al.c(this.clM, (int) R.drawable.icon_picture_packup_white_n);
            if (this.clI != null) {
                this.clI.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new am("c13339").bT("uid", this.mUserId).l("post_id", this.cke.threadId));
        return true;
    }

    private void aoV() {
        if (this.cke != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.cke.threadId), String.valueOf(this.cke.postId), this.cke.mIsSeeHost, this.cke.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createHistoryCfg));
        }
    }
}
