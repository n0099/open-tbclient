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
/* loaded from: classes16.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    private int flH;
    private TbImageView hyQ;
    private TbCornersImageView hyR;
    private ImageView hyS;
    private TextView hyT;
    private TBSpecificationBtn hyU;
    private f hyV;
    private boolean hyW;
    private float hyX;
    private float hyY;
    private float hyZ;
    private float hza;
    private float hzb;
    private float hzc;
    private float hzd;
    private float hze;
    private int hzf;
    private boolean hzg;
    private a hzh;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.hyW = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hyW = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hyW = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.hyQ = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.hyR = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.hyS = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.hyT = (TextView) findViewById(R.id.cell_forum_test_des);
        this.hyU = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.hyU.setTextSize(R.dimen.tbds42);
        this.hyU.setConfig(aVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.hyR.setCornerTopLeftRadius(dimens);
        this.hyQ.setRadius(dimens);
        this.hyQ.setConrers(3);
        this.hyQ.setPlaceHolder(3);
        this.hyQ.setDrawCorner(true);
        this.flH = l.getDimens(context, R.dimen.tbds262);
        this.hyS.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.hzg) {
            this.hyQ.getLayoutParams().height = this.mHeight - this.flH;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.hyS.setVisibility(0);
        } else {
            this.hyS.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.hzf = i;
    }

    public int getDataIndex() {
        return this.hzf;
    }

    public void setViewLeft(float f) {
        this.hyX = f;
    }

    public float getViewLeft() {
        return this.hyX;
    }

    public void setViewTop(float f) {
        this.hyY = f;
    }

    public float getViewTop() {
        return this.hyY;
    }

    public void setViewRight(float f) {
        this.hyZ = f;
    }

    public float getViewRight() {
        return this.hyZ;
    }

    public void setViewBottom(float f) {
        this.hza = f;
    }

    public float getViewBottom() {
        return this.hza;
    }

    public void setMoveLeft(float f) {
        this.hzb = f;
    }

    public float getMoveLeft() {
        return this.hzb;
    }

    public void setMoveTop(float f) {
        this.hzc = f;
    }

    public float getMoveTop() {
        return this.hzc;
    }

    public void setMoveRight(float f) {
        this.hzd = f;
    }

    public float getMoveRight() {
        return this.hzd;
    }

    public void setMoveBottom(float f) {
        this.hze = f;
    }

    public float getMoveBottom() {
        return this.hze;
    }

    public void setIsScale(boolean z) {
        this.hzg = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.hzh = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.hyV = fVar;
            this.hyQ.startLoad(fVar.hyM ? fVar.hyN : fVar.imageUrl, 10, false);
            this.hyW = false;
            String string = com.baidu.tbadk.core.sharedPref.b.bik().getString("enter_forum_test_id_list", "");
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
                        this.hyW = true;
                        break;
                    }
                }
            }
            this.hyR.setVisibility(this.hyW ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.hyT.setText(R.string.cell_forum_test_title_default);
            } else {
                this.hyT.setText(fVar.title);
            }
            this.hyU.setText(getResources().getString(fVar.hyM ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.hyV;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq a;
        if (this.hyS == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new aq("c13373").u("uid", TbadkCoreApplication.getCurrentAccountId()).u("obj_id", this.hyV.testId));
                if (this.hzh != null) {
                    this.hzh.wg(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.hyV.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bg.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new aq("c13372").u("uid", TbadkCoreApplication.getCurrentAccountId()).u("obj_id", this.hyV.testId));
            int i = this.hzf;
            f fVar = this.hyV;
            if (this.hyV != null && i >= 0 && (a = com.baidu.tieba.s.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.s.c.dvE().b(this.mPageId, a);
            }
            if (!this.hyW) {
                String string = com.baidu.tbadk.core.sharedPref.b.bik().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.hyV.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
                com.baidu.tbadk.core.sharedPref.b.bik().putString("enter_forum_test_id_list", sb.toString());
            }
            this.hyR.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.hyV.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.hyQ != null) {
                this.hyQ.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.hyU != null) {
                this.hyU.bkF();
            }
            SvgManager.bjq().a(this.hyR, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.hyT.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.e.a.bjQ().Z(dimens).Y(dimens).of(R.color.cp_bg_line_h).aZ(this.hyT);
            } else {
                ((ViewGroup.MarginLayoutParams) this.hyT.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.e.a.bjP().ou(R.color.cp_bg_line_h).op(l.getDimens(getContext(), R.dimen.tbds10)).oq(R.color.cp_shadow_a_alpha16).oo(4353).or(l.getDimens(getContext(), R.dimen.tbds10)).os(0).ot(l.getDimens(getContext(), R.dimen.tbds5)).aZ(this.hyT);
            }
            ap.setImageResource(this.hyS, R.drawable.icon_ba_close);
            ap.setViewTextColor(this.hyT, R.color.cp_cont_b);
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
