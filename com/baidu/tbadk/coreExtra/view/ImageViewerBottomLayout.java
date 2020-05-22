package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static final int egS = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private AgreeView dVU;
    private TextView dVV;
    private ImageView dVW;
    private ImageUrlData efD;
    private a egQ;
    private TextView egT;
    private ImageView egU;
    private View egV;
    private LinearLayout egW;
    private String mUserId;

    /* loaded from: classes8.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.egQ = null;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.egV = findViewById(R.id.unfold_root);
        this.egT = (TextView) findViewById(R.id.unfold_text);
        this.egU = (ImageView) findViewById(R.id.unfold_icon);
        this.egV.setVisibility(8);
        SvgManager.aUV().a(this.egU, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.egW = (LinearLayout) findViewById(R.id.image_viewer_comment_and_agree);
        this.dVW = (ImageView) findViewById(R.id.comment_icon);
        SvgManager.aUV().a(this.dVW, R.drawable.icon_pure_imageviewer_comment24_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dVV = (TextView) findViewById(R.id.comment_num);
        this.dVV.setText("0");
        this.dVU = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.dVU.setIsFromBigpic(true);
        this.dVU.setAgreeAnimationResource();
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = 13;
        cVar.dBf = 10;
        this.dVU.setStatisticData(cVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.egQ = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void setIsBjhDynamic(boolean z) {
        if (this.dVU != null) {
            this.dVU.setAgreeAlone(z);
        }
    }

    public void b(ImageUrlData imageUrlData) {
        this.efD = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.dVV.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.dVU.setData(imageUrlData.agreeData);
            }
            if (TextUtils.isEmpty(imageUrlData.richTextArray) || "[]".equals(imageUrlData.richTextArray)) {
                this.egV.setVisibility(4);
                return;
            } else {
                this.egV.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.dVW.setOnClickListener(this);
        this.dVV.setOnClickListener(this);
        this.egV.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void hK(boolean z) {
        if (z) {
            this.egT.setText(getContext().getString(R.string.expand));
            SvgManager.aUV().a(this.egU, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.egW.setVisibility(8);
            return;
        }
        this.egT.setText(getContext().getString(R.string.fold));
        SvgManager.aUV().a(this.egU, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.egW.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dVW || view == this.dVV) {
            if (this.efD != null) {
                an anVar = new an("c13685");
                anVar.s("tid", this.efD.threadId);
                anVar.dh("nid", this.efD.nid);
                anVar.dh("fid", this.efD.forumId);
                if (this.efD.from == "index") {
                    anVar.ag("obj_locate", 1);
                } else if (this.efD.from == "frs") {
                    anVar.ag("obj_locate", 2);
                } else if (this.efD.from == "pb") {
                    anVar.ag("obj_locate", 3);
                }
                TiebaStatic.log(anVar);
            }
            TiebaStatic.log(new an("c12942").dh("obj_type", "2").dh("obj_locate", "12"));
            bbi();
        } else if (view == this.egV) {
            if (this.egT.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.egT.setText(getContext().getString(R.string.fold));
                SvgManager.aUV().a(this.egU, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.egQ != null) {
                    this.egQ.a(this, true);
                    return;
                }
                return;
            }
            this.egT.setText(getContext().getString(R.string.expand));
            SvgManager.aUV().a(this.egU, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            if (this.egQ != null) {
                this.egQ.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new an("c13339").dh("uid", this.mUserId).s("post_id", this.efD.threadId));
        return true;
    }

    private void bbi() {
        if (this.efD != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.efD.threadId), String.valueOf(this.efD.postId), this.efD.mIsSeeHost, this.efD.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
