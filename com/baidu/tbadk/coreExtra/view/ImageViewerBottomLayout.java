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
/* loaded from: classes5.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static final int dnM = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private AgreeView dcQ;
    private TextView dcR;
    private ImageView dcS;
    private ImageUrlData dmk;
    private a dnK;
    private TextView dnN;
    private ImageView dnO;
    private View dnP;
    private boolean dnQ;
    private String mUserId;

    /* loaded from: classes5.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.dnK = null;
        this.dnQ = true;
        init(context);
        initListener();
    }

    public ImageViewerBottomLayout(Context context, boolean z) {
        super(context);
        this.dnK = null;
        this.dnQ = true;
        this.dnQ = z;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.dnP = findViewById(R.id.unfold_root);
        this.dnN = (TextView) findViewById(R.id.unfold_text);
        this.dnO = (ImageView) findViewById(R.id.unfold_icon);
        this.dnP.setVisibility(8);
        SvgManager.aDW().a(this.dnO, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dcS = (ImageView) findViewById(R.id.comment_icon);
        SvgManager.aDW().a(this.dcS, R.drawable.icon_pure_imageviewer_comment24_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dcR = (TextView) findViewById(R.id.comment_num);
        this.dcR.setText("0");
        this.dcQ = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.dcQ.setIsFromBigpic(true);
        this.dcQ.setAgreeAnimationResource();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJm = 13;
        dVar.cJs = 10;
        this.dcQ.setStatisticData(dVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.dnK = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void setIsBjhDynamic(boolean z) {
        if (this.dcQ != null) {
            this.dcQ.setAgreeAlone(z);
        }
    }

    public void b(ImageUrlData imageUrlData) {
        this.dmk = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.dcR.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.dcQ.setData(imageUrlData.agreeData);
            }
            if (!this.dnQ) {
                this.dnP.setVisibility(4);
                return;
            } else if (TextUtils.isEmpty(imageUrlData.richTextArray) || "[]".equals(imageUrlData.richTextArray)) {
                this.dnP.setVisibility(4);
                return;
            } else {
                this.dnP.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.dcS.setOnClickListener(this);
        this.dcR.setOnClickListener(this);
        this.dnP.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void gd(boolean z) {
        if (z) {
            this.dnN.setText(getContext().getString(R.string.expand));
            SvgManager.aDW().a(this.dnO, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            return;
        }
        this.dnN.setText(getContext().getString(R.string.fold));
        SvgManager.aDW().a(this.dnO, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dcS || view == this.dcR) {
            TiebaStatic.log(new an("c12942").cp("obj_type", "2").cp("obj_locate", "12"));
            aJG();
        } else if (view == this.dnP) {
            if (this.dnN.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.dnN.setText(getContext().getString(R.string.fold));
                SvgManager.aDW().a(this.dnO, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.dnK != null) {
                    this.dnK.a(this, true);
                    return;
                }
                return;
            }
            this.dnN.setText(getContext().getString(R.string.expand));
            SvgManager.aDW().a(this.dnO, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            if (this.dnK != null) {
                this.dnK.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new an("c13339").cp("uid", this.mUserId).s("post_id", this.dmk.threadId));
        return true;
    }

    private void aJG() {
        if (this.dmk != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.dmk.threadId), String.valueOf(this.dmk.postId), this.dmk.mIsSeeHost, this.dmk.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
