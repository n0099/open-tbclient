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
/* loaded from: classes9.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    private int eJx;
    private f gTA;
    private boolean gTB;
    private float gTC;
    private float gTD;
    private float gTE;
    private float gTF;
    private float gTG;
    private float gTH;
    private float gTI;
    private float gTJ;
    private int gTK;
    private boolean gTL;
    private a gTM;
    private TbImageView gTv;
    private TbCornersImageView gTw;
    private ImageView gTx;
    private TextView gTy;
    private TBSpecificationBtn gTz;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gTB = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gTB = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gTB = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.gTv = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.gTw = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.gTx = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.gTy = (TextView) findViewById(R.id.cell_forum_test_des);
        this.gTz = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.gTz.setTextSize(R.dimen.tbds42);
        this.gTz.setConfig(bVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.gTw.setCornerTopLeftRadius(dimens);
        this.gTv.setRadius(dimens);
        this.gTv.setConrers(3);
        this.gTv.setPlaceHolder(3);
        this.gTv.setDrawCorner(true);
        this.eJx = l.getDimens(context, R.dimen.tbds262);
        this.gTx.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.gTL) {
            this.gTv.getLayoutParams().height = this.mHeight - this.eJx;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.gTx.setVisibility(0);
        } else {
            this.gTx.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.gTK = i;
    }

    public int getDataIndex() {
        return this.gTK;
    }

    public void setViewLeft(float f) {
        this.gTC = f;
    }

    public float getViewLeft() {
        return this.gTC;
    }

    public void setViewTop(float f) {
        this.gTD = f;
    }

    public float getViewTop() {
        return this.gTD;
    }

    public void setViewRight(float f) {
        this.gTE = f;
    }

    public float getViewRight() {
        return this.gTE;
    }

    public void setViewBottom(float f) {
        this.gTF = f;
    }

    public float getViewBottom() {
        return this.gTF;
    }

    public void setMoveLeft(float f) {
        this.gTG = f;
    }

    public float getMoveLeft() {
        return this.gTG;
    }

    public void setMoveTop(float f) {
        this.gTH = f;
    }

    public float getMoveTop() {
        return this.gTH;
    }

    public void setMoveRight(float f) {
        this.gTI = f;
    }

    public float getMoveRight() {
        return this.gTI;
    }

    public void setMoveBottom(float f) {
        this.gTJ = f;
    }

    public float getMoveBottom() {
        return this.gTJ;
    }

    public void setIsScale(boolean z) {
        this.gTL = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.gTM = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.gTA = fVar;
            this.gTv.startLoad(fVar.gTr ? fVar.gTs : fVar.imageUrl, 10, false);
            this.gTB = false;
            String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("enter_forum_test_id_list", "");
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
                        this.gTB = true;
                        break;
                    }
                }
            }
            this.gTw.setVisibility(this.gTB ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.gTy.setText(R.string.cell_forum_test_title_default);
            } else {
                this.gTy.setText(fVar.title);
            }
            this.gTz.setText(getResources().getString(fVar.gTr ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.gTA;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an a;
        if (this.gTx == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new an("c13373").s("uid", TbadkCoreApplication.getCurrentAccountId()).s("obj_id", this.gTA.testId));
                if (this.gTM != null) {
                    this.gTM.sW(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.gTA.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bc.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new an("c13372").s("uid", TbadkCoreApplication.getCurrentAccountId()).s("obj_id", this.gTA.testId));
            int i = this.gTK;
            f fVar = this.gTA;
            if (this.gTA != null && i >= 0 && (a = com.baidu.tieba.s.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.s.c.dct().b(this.mPageId, a);
            }
            if (!this.gTB) {
                String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.gTA.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
                com.baidu.tbadk.core.sharedPref.b.aTX().putString("enter_forum_test_id_list", sb.toString());
            }
            this.gTw.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.gTA.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.gTv != null) {
                this.gTv.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.gTz != null) {
                this.gTz.aWq();
            }
            SvgManager.aUV().a(this.gTw, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.gTy.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.e.a.aVv().S(dimens).R(dimens).lo(R.color.cp_bg_line_h).aR(this.gTy);
            } else {
                ((ViewGroup.MarginLayoutParams) this.gTy.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.e.a.aVu().lD(R.color.cp_bg_line_h).ly(l.getDimens(getContext(), R.dimen.tbds10)).lz(R.color.cp_shadow_a_alpha16).lx(4353).lA(l.getDimens(getContext(), R.dimen.tbds10)).lB(0).lC(l.getDimens(getContext(), R.dimen.tbds5)).aR(this.gTy);
            }
            am.setImageResource(this.gTx, R.drawable.icon_ba_close);
            am.setViewTextColor(this.gTy, (int) R.color.cp_cont_b);
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
