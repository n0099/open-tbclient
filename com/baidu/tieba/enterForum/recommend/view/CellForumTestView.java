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
    private int fPd;
    private float inA;
    private float inB;
    private float inC;
    private float inD;
    private float inE;
    private float inF;
    private float inG;
    private int inH;
    private boolean inI;
    private a inJ;
    private TbImageView inr;

    /* renamed from: int  reason: not valid java name */
    private TbCornersImageView f3int;
    private ImageView inu;
    private TextView inv;
    private TBSpecificationBtn inw;
    private f inx;
    private boolean iny;
    private float inz;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iny = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iny = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iny = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.inr = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.f3int = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.inu = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.inv = (TextView) findViewById(R.id.cell_forum_test_des);
        this.inw = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.inw.setTextSize(R.dimen.tbds42);
        this.inw.setConfig(aVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.f3int.setCornerTopLeftRadius(dimens);
        this.inr.setRadius(dimens);
        this.inr.setConrers(3);
        this.inr.setPlaceHolder(3);
        this.inr.setDrawCorner(true);
        this.fPd = l.getDimens(context, R.dimen.tbds262);
        this.inu.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.inI) {
            this.inr.getLayoutParams().height = this.mHeight - this.fPd;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.inu.setVisibility(0);
        } else {
            this.inu.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.inH = i;
    }

    public int getDataIndex() {
        return this.inH;
    }

    public void setViewLeft(float f) {
        this.inz = f;
    }

    public float getViewLeft() {
        return this.inz;
    }

    public void setViewTop(float f) {
        this.inA = f;
    }

    public float getViewTop() {
        return this.inA;
    }

    public void setViewRight(float f) {
        this.inB = f;
    }

    public float getViewRight() {
        return this.inB;
    }

    public void setViewBottom(float f) {
        this.inC = f;
    }

    public float getViewBottom() {
        return this.inC;
    }

    public void setMoveLeft(float f) {
        this.inD = f;
    }

    public float getMoveLeft() {
        return this.inD;
    }

    public void setMoveTop(float f) {
        this.inE = f;
    }

    public float getMoveTop() {
        return this.inE;
    }

    public void setMoveRight(float f) {
        this.inF = f;
    }

    public float getMoveRight() {
        return this.inF;
    }

    public void setMoveBottom(float f) {
        this.inG = f;
    }

    public float getMoveBottom() {
        return this.inG;
    }

    public void setIsScale(boolean z) {
        this.inI = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.inJ = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.inx = fVar;
            this.inr.startLoad(fVar.inn ? fVar.ino : fVar.imageUrl, 10, false);
            this.iny = false;
            String string = com.baidu.tbadk.core.sharedPref.b.bqh().getString("enter_forum_test_id_list", "");
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
                        this.iny = true;
                        break;
                    }
                }
            }
            this.f3int.setVisibility(this.iny ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.inv.setText(R.string.cell_forum_test_title_default);
            } else {
                this.inv.setText(fVar.title);
            }
            this.inw.setText(getResources().getString(fVar.inn ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.inx;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq a2;
        if (this.inu == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new aq("c13373").w("uid", TbadkCoreApplication.getCurrentAccountId()).w("obj_id", this.inx.testId));
                if (this.inJ != null) {
                    this.inJ.xR(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.inx.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bg.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new aq("c13372").w("uid", TbadkCoreApplication.getCurrentAccountId()).w("obj_id", this.inx.testId));
            int i = this.inH;
            f fVar = this.inx;
            if (this.inx != null && i >= 0 && (a2 = com.baidu.tieba.s.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.s.c.dIX().b(this.mPageId, a2);
            }
            if (!this.iny) {
                String string = com.baidu.tbadk.core.sharedPref.b.bqh().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.inx.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
                com.baidu.tbadk.core.sharedPref.b.bqh().putString("enter_forum_test_id_list", sb.toString());
            }
            this.f3int.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.inx.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.inr != null) {
                this.inr.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.inw != null) {
                this.inw.bsD();
            }
            SvgManager.brn().a(this.f3int, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.inv.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.e.a.brO().af(dimens).ae(dimens).pk(R.color.cp_bg_line_h).bk(this.inv);
            } else {
                ((ViewGroup.MarginLayoutParams) this.inv.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.e.a.brN().pA(R.color.cp_bg_line_h).pv(l.getDimens(getContext(), R.dimen.tbds10)).pw(R.color.cp_shadow_a_alpha16).pu(4353).px(l.getDimens(getContext(), R.dimen.tbds10)).py(0).pz(l.getDimens(getContext(), R.dimen.tbds5)).bk(this.inv);
            }
            ap.setImageResource(this.inu, R.drawable.icon_ba_close);
            ap.setViewTextColor(this.inv, R.color.cp_cont_b);
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
