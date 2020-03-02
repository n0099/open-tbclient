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
    public static final int dsh = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private AgreeView dhg;
    private TextView dhh;
    private ImageView dhi;
    private ImageUrlData dqI;
    private a dsf;
    private TextView dsi;
    private ImageView dsj;
    private View dsk;
    private boolean dsl;
    private String mUserId;

    /* loaded from: classes8.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.dsf = null;
        this.dsl = true;
        init(context);
        initListener();
    }

    public ImageViewerBottomLayout(Context context, boolean z) {
        super(context);
        this.dsf = null;
        this.dsl = true;
        this.dsl = z;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.dsk = findViewById(R.id.unfold_root);
        this.dsi = (TextView) findViewById(R.id.unfold_text);
        this.dsj = (ImageView) findViewById(R.id.unfold_icon);
        this.dsk.setVisibility(8);
        SvgManager.aGC().a(this.dsj, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dhi = (ImageView) findViewById(R.id.comment_icon);
        SvgManager.aGC().a(this.dhi, R.drawable.icon_pure_imageviewer_comment24_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dhh = (TextView) findViewById(R.id.comment_num);
        this.dhh.setText("0");
        this.dhg = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.dhg.setIsFromBigpic(true);
        this.dhg.setAgreeAnimationResource();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNB = 13;
        dVar.cNH = 10;
        this.dhg.setStatisticData(dVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.dsf = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void setIsBjhDynamic(boolean z) {
        if (this.dhg != null) {
            this.dhg.setAgreeAlone(z);
        }
    }

    public void b(ImageUrlData imageUrlData) {
        this.dqI = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.dhh.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.dhg.setData(imageUrlData.agreeData);
            }
            if (!this.dsl) {
                this.dsk.setVisibility(4);
                return;
            } else if (TextUtils.isEmpty(imageUrlData.richTextArray) || "[]".equals(imageUrlData.richTextArray)) {
                this.dsk.setVisibility(4);
                return;
            } else {
                this.dsk.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.dhi.setOnClickListener(this);
        this.dhh.setOnClickListener(this);
        this.dsk.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void gp(boolean z) {
        if (z) {
            this.dsi.setText(getContext().getString(R.string.expand));
            SvgManager.aGC().a(this.dsj, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            return;
        }
        this.dsi.setText(getContext().getString(R.string.fold));
        SvgManager.aGC().a(this.dsj, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dhi || view == this.dhh) {
            TiebaStatic.log(new an("c12942").cy("obj_type", "2").cy("obj_locate", "12"));
            aMy();
        } else if (view == this.dsk) {
            if (this.dsi.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.dsi.setText(getContext().getString(R.string.fold));
                SvgManager.aGC().a(this.dsj, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.dsf != null) {
                    this.dsf.a(this, true);
                    return;
                }
                return;
            }
            this.dsi.setText(getContext().getString(R.string.expand));
            SvgManager.aGC().a(this.dsj, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            if (this.dsf != null) {
                this.dsf.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new an("c13339").cy("uid", this.mUserId).s("post_id", this.dqI.threadId));
        return true;
    }

    private void aMy() {
        if (this.dqI != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.dqI.threadId), String.valueOf(this.dqI.postId), this.dqI.mIsSeeHost, this.dqI.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
