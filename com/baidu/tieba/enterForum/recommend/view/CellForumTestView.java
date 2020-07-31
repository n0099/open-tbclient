package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumTestActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbCornersImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.message.RequestTestCloseMessage;
/* loaded from: classes16.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    private int fap;
    private TbImageView hlZ;
    private TbCornersImageView hma;
    private ImageView hmb;
    private TextView hmc;
    private TBSpecificationBtn hmd;
    private f hme;
    private boolean hmf;
    private float hmg;
    private float hmh;
    private float hmi;
    private float hmj;
    private float hmk;
    private float hml;
    private float hmm;
    private float hmn;
    private int hmo;
    private boolean hmp;
    private a hmq;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.hmf = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hmf = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hmf = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.hlZ = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.hma = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.hmb = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.hmc = (TextView) findViewById(R.id.cell_forum_test_des);
        this.hmd = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.hmd.setTextSize(R.dimen.tbds42);
        this.hmd.setConfig(bVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.hma.setCornerTopLeftRadius(dimens);
        this.hlZ.setRadius(dimens);
        this.hlZ.setConrers(3);
        this.hlZ.setPlaceHolder(3);
        this.hlZ.setDrawCorner(true);
        this.fap = l.getDimens(context, R.dimen.tbds262);
        this.hmb.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.hmp) {
            this.hlZ.getLayoutParams().height = this.mHeight - this.fap;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.hmb.setVisibility(0);
        } else {
            this.hmb.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.hmo = i;
    }

    public int getDataIndex() {
        return this.hmo;
    }

    public void setViewLeft(float f) {
        this.hmg = f;
    }

    public float getViewLeft() {
        return this.hmg;
    }

    public void setViewTop(float f) {
        this.hmh = f;
    }

    public float getViewTop() {
        return this.hmh;
    }

    public void setViewRight(float f) {
        this.hmi = f;
    }

    public float getViewRight() {
        return this.hmi;
    }

    public void setViewBottom(float f) {
        this.hmj = f;
    }

    public float getViewBottom() {
        return this.hmj;
    }

    public void setMoveLeft(float f) {
        this.hmk = f;
    }

    public float getMoveLeft() {
        return this.hmk;
    }

    public void setMoveTop(float f) {
        this.hml = f;
    }

    public float getMoveTop() {
        return this.hml;
    }

    public void setMoveRight(float f) {
        this.hmm = f;
    }

    public float getMoveRight() {
        return this.hmm;
    }

    public void setMoveBottom(float f) {
        this.hmn = f;
    }

    public float getMoveBottom() {
        return this.hmn;
    }

    public void setIsScale(boolean z) {
        this.hmp = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.hmq = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.hme = fVar;
            this.hlZ.startLoad(fVar.hlV ? fVar.hlW : fVar.imageUrl, 10, false);
            this.hmf = false;
            String string = com.baidu.tbadk.core.sharedPref.b.aZP().getString("enter_forum_test_id_list", "");
            String[] split = string.split("[|]");
            if (!StringUtils.isNull(string)) {
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = split[i];
                    if (StringUtils.isNull(str) || !str.equals(fVar.testId + "*" + TbadkCoreApplication.getCurrentAccountId())) {
                        i++;
                    } else {
                        this.hmf = true;
                        break;
                    }
                }
            }
            this.hma.setVisibility(this.hmf ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.hmc.setText(R.string.cell_forum_test_title_default);
            } else {
                this.hmc.setText(fVar.title);
            }
            this.hmd.setText(getResources().getString(fVar.hlV ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.hme;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ap a;
        if (this.hmb == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new ap("c13373").t("uid", TbadkCoreApplication.getCurrentAccountId()).t("obj_id", this.hme.testId));
                if (this.hmq != null) {
                    this.hmq.tR(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.hme.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bf.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new ap("c13372").t("uid", TbadkCoreApplication.getCurrentAccountId()).t("obj_id", this.hme.testId));
            int i = this.hmo;
            f fVar = this.hme;
            if (this.hme != null && i >= 0 && (a = com.baidu.tieba.s.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.s.c.dkh().b(this.mPageId, a);
            }
            if (!this.hmf) {
                String string = com.baidu.tbadk.core.sharedPref.b.aZP().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.hme.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
                StringBuilder sb = new StringBuilder();
                if (split.length < 20) {
                    sb.append(string).append("|").append(str);
                } else {
                    int i2 = 0;
                    for (String str2 : split) {
                        if (i2 != 0) {
                            sb.append(str2).append("|");
                        }
                        i2++;
                    }
                    sb.append(str);
                }
                com.baidu.tbadk.core.sharedPref.b.aZP().putString("enter_forum_test_id_list", sb.toString());
            }
            this.hma.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.hme.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.hlZ != null) {
                this.hlZ.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.hmd != null) {
                this.hmd.bci();
            }
            SvgManager.baR().a(this.hma, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.hmc.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.e.a.bbr().U(dimens).T(dimens).mb(R.color.cp_bg_line_h).aX(this.hmc);
            } else {
                ((ViewGroup.MarginLayoutParams) this.hmc.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.e.a.bbq().mq(R.color.cp_bg_line_h).ml(l.getDimens(getContext(), R.dimen.tbds10)).mm(R.color.cp_shadow_a_alpha16).mk(4353).mn(l.getDimens(getContext(), R.dimen.tbds10)).mo(0).mp(l.getDimens(getContext(), R.dimen.tbds5)).aX(this.hmc);
            }
            ao.setImageResource(this.hmb, R.drawable.icon_ba_close);
            ao.setViewTextColor(this.hmc, R.color.cp_cont_b);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}
