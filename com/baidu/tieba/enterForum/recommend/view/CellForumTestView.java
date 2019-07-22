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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumTestActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.message.RequestTestCloseMessage;
/* loaded from: classes4.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    private TextView bNY;
    private int cSB;
    private TbImageView eZE;
    private ImageView eZF;
    private ImageView eZG;
    private TextView eZH;
    private f eZI;
    private boolean eZJ;
    private float eZK;
    private float eZL;
    private float eZM;
    private float eZN;
    private float eZO;
    private float eZP;
    private float eZQ;
    private float eZR;
    private int eZS;
    private boolean eZT;
    private a eZU;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eZJ = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eZJ = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eZJ = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.eZE = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.eZF = (ImageView) findViewById(R.id.cell_forum_test_new);
        this.eZG = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.eZH = (TextView) findViewById(R.id.cell_forum_test_des);
        this.bNY = (TextView) findViewById(R.id.cell_forum_test_btn);
        this.eZE.setRadius(l.g(context, R.dimen.tbds22));
        this.eZE.setConrers(3);
        this.eZE.setDefaultBgResource(R.color.cp_atp_a);
        this.eZE.setDrawCorner(true);
        this.cSB = l.g(context, R.dimen.tbds262);
        this.eZG.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.eZT) {
            this.eZE.getLayoutParams().height = this.mHeight - this.cSB;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.eZG.setVisibility(0);
        } else {
            this.eZG.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.eZS = i;
    }

    public int getDataIndex() {
        return this.eZS;
    }

    public void setViewLeft(float f) {
        this.eZK = f;
    }

    public float getViewLeft() {
        return this.eZK;
    }

    public void setViewTop(float f) {
        this.eZL = f;
    }

    public float getViewTop() {
        return this.eZL;
    }

    public void setViewRight(float f) {
        this.eZM = f;
    }

    public float getViewRight() {
        return this.eZM;
    }

    public void setViewBottom(float f) {
        this.eZN = f;
    }

    public float getViewBottom() {
        return this.eZN;
    }

    public void setMoveLeft(float f) {
        this.eZO = f;
    }

    public float getMoveLeft() {
        return this.eZO;
    }

    public void setMoveTop(float f) {
        this.eZP = f;
    }

    public float getMoveTop() {
        return this.eZP;
    }

    public void setMoveRight(float f) {
        this.eZQ = f;
    }

    public float getMoveRight() {
        return this.eZQ;
    }

    public void setMoveBottom(float f) {
        this.eZR = f;
    }

    public float getMoveBottom() {
        return this.eZR;
    }

    public void setIsScale(boolean z) {
        this.eZT = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.eZU = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.eZI = fVar;
            if (fVar.eZA) {
                this.eZE.startLoad(fVar.eZB, 10, false);
            } else {
                this.eZE.startLoad(fVar.imageUrl, 10, false);
            }
            this.eZJ = false;
            String string = com.baidu.tbadk.core.sharedPref.b.ahO().getString("enter_forum_test_id_list", "");
            String[] split = string.split("[|]");
            if (!StringUtils.isNull(string)) {
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = split[i];
                    if (StringUtils.isNull(str) || !str.equals(String.valueOf(fVar.testId) + "*" + TbadkCoreApplication.getCurrentAccountId())) {
                        i++;
                    } else {
                        this.eZJ = true;
                        break;
                    }
                }
            }
            this.eZF.setVisibility(this.eZJ ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.eZH.setText(R.string.cell_forum_test_title_default);
            } else {
                this.eZH.setText(fVar.title);
            }
            if (fVar.eZA) {
                this.bNY.setText(R.string.cell_forum_retest_default);
            } else {
                this.bNY.setText(R.string.cell_forum_test_default);
            }
        }
    }

    public f getData() {
        return this.eZI;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an a;
        if (this.eZG == view) {
            if (j.jQ() && this.mIndex == 1) {
                TiebaStatic.log(new an("c13373").l("uid", TbadkCoreApplication.getCurrentAccountId()).l(VideoPlayActivityConfig.OBJ_ID, this.eZI.testId));
                if (this.eZU != null) {
                    this.eZU.qD(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.eZI.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bd.cF(getContext())) {
            TiebaStatic.log(new an("c13372").l("uid", TbadkCoreApplication.getCurrentAccountId()).l(VideoPlayActivityConfig.OBJ_ID, this.eZI.testId));
            int i = this.eZS;
            f fVar = this.eZI;
            if (this.eZI != null && i >= 0 && (a = com.baidu.tieba.q.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.q.c.coo().b(this.mPageId, a);
            }
            if (!this.eZJ) {
                String string = com.baidu.tbadk.core.sharedPref.b.ahO().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                StringBuilder sb = new StringBuilder();
                if (split.length < 20) {
                    sb.append(string).append("|").append(String.valueOf(this.eZI.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                } else {
                    int i2 = 0;
                    for (String str : split) {
                        if (i2 != 0) {
                            sb.append(str).append("|");
                        }
                        i2++;
                    }
                    sb.append(String.valueOf(this.eZI.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                }
                com.baidu.tbadk.core.sharedPref.b.ahO().putString("enter_forum_test_id_list", sb.toString());
            }
            this.eZF.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumTestActivityConfig(getContext(), this.eZI.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.eZE.setIsNight(this.mSkinType == 1);
            am.c(this.eZF, (int) R.drawable.icon_ba_new);
            am.c(this.eZG, (int) R.drawable.icon_ba_close);
            am.j(this.eZH, R.color.cp_cont_b);
            am.k(this.eZH, R.drawable.forum_test_shade_bg);
            am.j(this.bNY, R.color.cp_btn_a);
            am.k(this.bNY, R.drawable.enter_forum_test_shade_bg);
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
