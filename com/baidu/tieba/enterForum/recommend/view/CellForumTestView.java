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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbCornersImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.message.RequestTestCloseMessage;
/* loaded from: classes22.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    private int fJn;
    private float ihA;
    private float ihB;
    private float ihC;
    private float ihD;
    private float ihE;
    private float ihF;
    private float ihG;
    private float ihH;
    private int ihI;
    private boolean ihJ;
    private a ihK;
    private TbImageView iht;
    private TbCornersImageView ihu;
    private ImageView ihv;
    private TextView ihw;
    private TBSpecificationBtn ihx;
    private f ihy;
    private boolean ihz;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ihz = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ihz = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ihz = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.iht = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.ihu = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.ihv = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.ihw = (TextView) findViewById(R.id.cell_forum_test_des);
        this.ihx = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.ihx.setTextSize(R.dimen.tbds42);
        this.ihx.setConfig(aVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.ihu.setCornerTopLeftRadius(dimens);
        this.iht.setRadius(dimens);
        this.iht.setConrers(3);
        this.iht.setPlaceHolder(3);
        this.iht.setDrawCorner(true);
        this.fJn = l.getDimens(context, R.dimen.tbds262);
        this.ihv.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.ihJ) {
            this.iht.getLayoutParams().height = this.mHeight - this.fJn;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.ihv.setVisibility(0);
        } else {
            this.ihv.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.ihI = i;
    }

    public int getDataIndex() {
        return this.ihI;
    }

    public void setViewLeft(float f) {
        this.ihA = f;
    }

    public float getViewLeft() {
        return this.ihA;
    }

    public void setViewTop(float f) {
        this.ihB = f;
    }

    public float getViewTop() {
        return this.ihB;
    }

    public void setViewRight(float f) {
        this.ihC = f;
    }

    public float getViewRight() {
        return this.ihC;
    }

    public void setViewBottom(float f) {
        this.ihD = f;
    }

    public float getViewBottom() {
        return this.ihD;
    }

    public void setMoveLeft(float f) {
        this.ihE = f;
    }

    public float getMoveLeft() {
        return this.ihE;
    }

    public void setMoveTop(float f) {
        this.ihF = f;
    }

    public float getMoveTop() {
        return this.ihF;
    }

    public void setMoveRight(float f) {
        this.ihG = f;
    }

    public float getMoveRight() {
        return this.ihG;
    }

    public void setMoveBottom(float f) {
        this.ihH = f;
    }

    public float getMoveBottom() {
        return this.ihH;
    }

    public void setIsScale(boolean z) {
        this.ihJ = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.ihK = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.ihy = fVar;
            this.iht.startLoad(fVar.ihp ? fVar.ihq : fVar.imageUrl, 10, false);
            this.ihz = false;
            String string = com.baidu.tbadk.core.sharedPref.b.bnH().getString("enter_forum_test_id_list", "");
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
                        this.ihz = true;
                        break;
                    }
                }
            }
            this.ihu.setVisibility(this.ihz ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.ihw.setText(R.string.cell_forum_test_title_default);
            } else {
                this.ihw.setText(fVar.title);
            }
            this.ihx.setText(getResources().getString(fVar.ihp ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.ihy;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq a2;
        if (this.ihv == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new aq("c13373").w("uid", TbadkCoreApplication.getCurrentAccountId()).w("obj_id", this.ihy.testId));
                if (this.ihK != null) {
                    this.ihK.xE(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.ihy.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bg.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new aq("c13372").w("uid", TbadkCoreApplication.getCurrentAccountId()).w("obj_id", this.ihy.testId));
            int i = this.ihI;
            f fVar = this.ihy;
            if (this.ihy != null && i >= 0 && (a2 = com.baidu.tieba.s.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.s.c.dGv().b(this.mPageId, a2);
            }
            if (!this.ihz) {
                String string = com.baidu.tbadk.core.sharedPref.b.bnH().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.ihy.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
                com.baidu.tbadk.core.sharedPref.b.bnH().putString("enter_forum_test_id_list", sb.toString());
            }
            this.ihu.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.ihy.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.iht != null) {
                this.iht.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.ihx != null) {
                this.ihx.bqd();
            }
            SvgManager.boN().a(this.ihu, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.ihw.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.e.a.bpo().ad(dimens).ac(dimens).pa(R.color.cp_bg_line_h).bg(this.ihw);
            } else {
                ((ViewGroup.MarginLayoutParams) this.ihw.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.e.a.bpn().pq(R.color.cp_bg_line_h).pk(l.getDimens(getContext(), R.dimen.tbds10)).pl(R.color.cp_shadow_a_alpha16).pj(4353).pm(l.getDimens(getContext(), R.dimen.tbds10)).po(0).pp(l.getDimens(getContext(), R.dimen.tbds5)).bg(this.ihw);
            }
            ap.setImageResource(this.ihv, R.drawable.icon_ba_close);
            ap.setViewTextColor(this.ihw, R.color.cp_cont_b);
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
