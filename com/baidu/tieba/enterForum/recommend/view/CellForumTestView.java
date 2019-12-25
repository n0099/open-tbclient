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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbCornersImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.message.RequestTestCloseMessage;
/* loaded from: classes6.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    private int dPY;
    private TbImageView fRV;
    private TbCornersImageView fRW;
    private ImageView fRX;
    private TextView fRY;
    private TBSpecificationBtn fRZ;
    private f fSa;
    private boolean fSb;
    private float fSc;
    private float fSd;
    private float fSe;
    private float fSf;
    private float fSg;
    private float fSh;
    private float fSi;
    private float fSj;
    private int fSk;
    private boolean fSl;
    private a fSm;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fSb = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fSb = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fSb = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.fRV = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.fRW = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.fRX = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.fRY = (TextView) findViewById(R.id.cell_forum_test_des);
        this.fRZ = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.fRZ.setTextSize(R.dimen.tbds42);
        this.fRZ.setConfig(bVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.fRW.setCornerTopLeftRadius(dimens);
        this.fRV.setRadius(dimens);
        this.fRV.setConrers(3);
        this.fRV.setPlaceHolder(3);
        this.fRV.setDrawCorner(true);
        this.dPY = l.getDimens(context, R.dimen.tbds262);
        this.fRX.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.fSl) {
            this.fRV.getLayoutParams().height = this.mHeight - this.dPY;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.fRX.setVisibility(0);
        } else {
            this.fRX.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.fSk = i;
    }

    public int getDataIndex() {
        return this.fSk;
    }

    public void setViewLeft(float f) {
        this.fSc = f;
    }

    public float getViewLeft() {
        return this.fSc;
    }

    public void setViewTop(float f) {
        this.fSd = f;
    }

    public float getViewTop() {
        return this.fSd;
    }

    public void setViewRight(float f) {
        this.fSe = f;
    }

    public float getViewRight() {
        return this.fSe;
    }

    public void setViewBottom(float f) {
        this.fSf = f;
    }

    public float getViewBottom() {
        return this.fSf;
    }

    public void setMoveLeft(float f) {
        this.fSg = f;
    }

    public float getMoveLeft() {
        return this.fSg;
    }

    public void setMoveTop(float f) {
        this.fSh = f;
    }

    public float getMoveTop() {
        return this.fSh;
    }

    public void setMoveRight(float f) {
        this.fSi = f;
    }

    public float getMoveRight() {
        return this.fSi;
    }

    public void setMoveBottom(float f) {
        this.fSj = f;
    }

    public float getMoveBottom() {
        return this.fSj;
    }

    public void setIsScale(boolean z) {
        this.fSl = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.fSm = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.fSa = fVar;
            this.fRV.startLoad(fVar.fRR ? fVar.fRS : fVar.imageUrl, 10, false);
            this.fSb = false;
            String string = com.baidu.tbadk.core.sharedPref.b.aCY().getString("enter_forum_test_id_list", "");
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
                        this.fSb = true;
                        break;
                    }
                }
            }
            this.fRW.setVisibility(this.fSb ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.fRY.setText(R.string.cell_forum_test_title_default);
            } else {
                this.fRY.setText(fVar.title);
            }
            this.fRZ.setText(getResources().getString(fVar.fRR ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.fSa;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an a;
        if (this.fRX == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new an("c13373").s("uid", TbadkCoreApplication.getCurrentAccountId()).s("obj_id", this.fSa.testId));
                if (this.fSm != null) {
                    this.fSm.rJ(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.fSa.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bc.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new an("c13372").s("uid", TbadkCoreApplication.getCurrentAccountId()).s("obj_id", this.fSa.testId));
            int i = this.fSk;
            f fVar = this.fSa;
            if (this.fSa != null && i >= 0 && (a = com.baidu.tieba.r.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.r.c.cHo().b(this.mPageId, a);
            }
            if (!this.fSb) {
                String string = com.baidu.tbadk.core.sharedPref.b.aCY().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.fSa.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
                com.baidu.tbadk.core.sharedPref.b.aCY().putString("enter_forum_test_id_list", sb.toString());
            }
            this.fRW.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.fSa.testId)));
        }
    }

    public void onChangeSkinType() {
        boolean z = true;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.fRV != null) {
                TbImageView tbImageView = this.fRV;
                if (this.mSkinType != 1 && skinType != 4) {
                    z = false;
                }
                tbImageView.setIsNight(z);
            }
            if (this.fRZ != null) {
                this.fRZ.aFd();
            }
            SvgManager.aDW().a(this.fRW, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.f.a.aEs().kA(R.color.cp_bg_line_h).kv(l.getDimens(getContext(), R.dimen.tbds10)).kw(R.color.cp_shadow_a_alpha16).ku(4353).kx(l.getDimens(getContext(), R.dimen.tbds10)).ky(0).kz(l.getDimens(getContext(), R.dimen.tbds5)).aM(this.fRY);
            am.setImageResource(this.fRX, R.drawable.icon_ba_close);
            am.setViewTextColor(this.fRY, (int) R.color.cp_cont_b);
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
