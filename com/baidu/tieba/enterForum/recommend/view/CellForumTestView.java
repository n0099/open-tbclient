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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbCornersImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.message.RequestTestCloseMessage;
/* loaded from: classes21.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    private int fOJ;
    private TbImageView iog;
    private TbCornersImageView ioh;
    private ImageView ioi;
    private TextView ioj;
    private TBSpecificationBtn iok;
    private f iol;
    private boolean iom;
    private float ion;
    private float ioo;
    private float iop;
    private float ioq;
    private float ior;
    private float ios;
    private float iot;
    private float iou;
    private int iov;
    private boolean iow;
    private a iox;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iom = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iom = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iom = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.iog = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.ioh = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.ioi = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.ioj = (TextView) findViewById(R.id.cell_forum_test_des);
        this.iok = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.iok.setTextSize(R.dimen.tbds42);
        this.iok.setConfig(aVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.ioh.setCornerTopLeftRadius(dimens);
        this.iog.setRadius(dimens);
        this.iog.setConrers(3);
        this.iog.setPlaceHolder(3);
        this.iog.setDrawCorner(true);
        this.fOJ = l.getDimens(context, R.dimen.tbds262);
        this.ioi.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.iow) {
            this.iog.getLayoutParams().height = this.mHeight - this.fOJ;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.ioi.setVisibility(0);
        } else {
            this.ioi.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.iov = i;
    }

    public int getDataIndex() {
        return this.iov;
    }

    public void setViewLeft(float f) {
        this.ion = f;
    }

    public float getViewLeft() {
        return this.ion;
    }

    public void setViewTop(float f) {
        this.ioo = f;
    }

    public float getViewTop() {
        return this.ioo;
    }

    public void setViewRight(float f) {
        this.iop = f;
    }

    public float getViewRight() {
        return this.iop;
    }

    public void setViewBottom(float f) {
        this.ioq = f;
    }

    public float getViewBottom() {
        return this.ioq;
    }

    public void setMoveLeft(float f) {
        this.ior = f;
    }

    public float getMoveLeft() {
        return this.ior;
    }

    public void setMoveTop(float f) {
        this.ios = f;
    }

    public float getMoveTop() {
        return this.ios;
    }

    public void setMoveRight(float f) {
        this.iot = f;
    }

    public float getMoveRight() {
        return this.iot;
    }

    public void setMoveBottom(float f) {
        this.iou = f;
    }

    public float getMoveBottom() {
        return this.iou;
    }

    public void setIsScale(boolean z) {
        this.iow = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.iox = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.iol = fVar;
            this.iog.startLoad(fVar.ioc ? fVar.iod : fVar.imageUrl, 10, false);
            this.iom = false;
            String string = com.baidu.tbadk.core.sharedPref.b.bpu().getString("enter_forum_test_id_list", "");
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
                        this.iom = true;
                        break;
                    }
                }
            }
            this.ioh.setVisibility(this.iom ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.ioj.setText(R.string.cell_forum_test_title_default);
            } else {
                this.ioj.setText(fVar.title);
            }
            this.iok.setText(getResources().getString(fVar.ioc ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.iol;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ar a2;
        if (this.ioi == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new ar("c13373").w("uid", TbadkCoreApplication.getCurrentAccountId()).w("obj_id", this.iol.testId));
                if (this.iox != null) {
                    this.iox.yp(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.iol.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bh.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new ar("c13372").w("uid", TbadkCoreApplication.getCurrentAccountId()).w("obj_id", this.iol.testId));
            int i = this.iov;
            f fVar = this.iol;
            if (this.iol != null && i >= 0 && (a2 = com.baidu.tieba.t.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.t.c.dIO().b(this.mPageId, a2);
            }
            if (!this.iom) {
                String string = com.baidu.tbadk.core.sharedPref.b.bpu().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.iol.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
                com.baidu.tbadk.core.sharedPref.b.bpu().putString("enter_forum_test_id_list", sb.toString());
            }
            this.ioh.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.iol.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.iog != null) {
                this.iog.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.iok != null) {
                this.iok.brT();
            }
            SvgManager.bqB().a(this.ioh, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.ioj.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.e.a.brc().ag(dimens).af(dimens).pG(R.color.CAM_X0207).bn(this.ioj);
            } else {
                ((ViewGroup.MarginLayoutParams) this.ioj.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.e.a.brb().pX(R.color.CAM_X0207).pS(l.getDimens(getContext(), R.dimen.tbds10)).pT(R.color.CAM_X0804).pR(4353).pU(l.getDimens(getContext(), R.dimen.tbds10)).pV(0).pW(l.getDimens(getContext(), R.dimen.tbds5)).bn(this.ioj);
            }
            ap.setImageResource(this.ioi, R.drawable.icon_ba_close);
            ap.setViewTextColor(this.ioj, R.color.CAM_X0105);
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
