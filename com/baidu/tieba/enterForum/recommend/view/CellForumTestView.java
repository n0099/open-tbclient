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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.message.RequestTestCloseMessage;
/* loaded from: classes4.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    private TextView bMW;
    private int cRd;
    private TbImageView eUC;
    private ImageView eUD;
    private ImageView eUE;
    private TextView eUF;
    private f eUG;
    private boolean eUH;
    private float eUI;
    private float eUJ;
    private float eUK;
    private float eUL;
    private float eUM;
    private float eUN;
    private float eUO;
    private float eUP;
    private int eUQ;
    private boolean eUR;
    private a eUS;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eUH = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eUH = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eUH = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.eUC = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.eUD = (ImageView) findViewById(R.id.cell_forum_test_new);
        this.eUE = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.eUF = (TextView) findViewById(R.id.cell_forum_test_des);
        this.bMW = (TextView) findViewById(R.id.cell_forum_test_btn);
        this.eUC.setRadius(l.g(context, R.dimen.tbds22));
        this.eUC.setConrers(3);
        this.eUC.setDefaultBgResource(R.color.cp_atp_a);
        this.eUC.setDrawCorner(true);
        this.cRd = l.g(context, R.dimen.tbds262);
        this.eUE.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.eUR) {
            this.eUC.getLayoutParams().height = this.mHeight - this.cRd;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.eUE.setVisibility(0);
        } else {
            this.eUE.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.eUQ = i;
    }

    public int getDataIndex() {
        return this.eUQ;
    }

    public void setViewLeft(float f) {
        this.eUI = f;
    }

    public float getViewLeft() {
        return this.eUI;
    }

    public void setViewTop(float f) {
        this.eUJ = f;
    }

    public float getViewTop() {
        return this.eUJ;
    }

    public void setViewRight(float f) {
        this.eUK = f;
    }

    public float getViewRight() {
        return this.eUK;
    }

    public void setViewBottom(float f) {
        this.eUL = f;
    }

    public float getViewBottom() {
        return this.eUL;
    }

    public void setMoveLeft(float f) {
        this.eUM = f;
    }

    public float getMoveLeft() {
        return this.eUM;
    }

    public void setMoveTop(float f) {
        this.eUN = f;
    }

    public float getMoveTop() {
        return this.eUN;
    }

    public void setMoveRight(float f) {
        this.eUO = f;
    }

    public float getMoveRight() {
        return this.eUO;
    }

    public void setMoveBottom(float f) {
        this.eUP = f;
    }

    public float getMoveBottom() {
        return this.eUP;
    }

    public void setIsScale(boolean z) {
        this.eUR = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.eUS = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.eUG = fVar;
            if (fVar.eUy) {
                this.eUC.startLoad(fVar.eUz, 10, false);
            } else {
                this.eUC.startLoad(fVar.imageUrl, 10, false);
            }
            this.eUH = false;
            String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("enter_forum_test_id_list", "");
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
                        this.eUH = true;
                        break;
                    }
                }
            }
            this.eUD.setVisibility(this.eUH ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.eUF.setText(R.string.cell_forum_test_title_default);
            } else {
                this.eUF.setText(fVar.title);
            }
            if (fVar.eUy) {
                this.bMW.setText(R.string.cell_forum_retest_default);
            } else {
                this.bMW.setText(R.string.cell_forum_test_default);
            }
        }
    }

    public f getData() {
        return this.eUG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        am a;
        if (this.eUE == view) {
            if (j.jG() && this.mIndex == 1) {
                TiebaStatic.log(new am("c13373").l("uid", TbadkCoreApplication.getCurrentAccountId()).l(VideoPlayActivityConfig.OBJ_ID, this.eUG.testId));
                if (this.eUS != null) {
                    this.eUS.ql(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.eUG.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bc.cE(getContext())) {
            TiebaStatic.log(new am("c13372").l("uid", TbadkCoreApplication.getCurrentAccountId()).l(VideoPlayActivityConfig.OBJ_ID, this.eUG.testId));
            int i = this.eUQ;
            f fVar = this.eUG;
            if (this.eUG != null && i >= 0 && (a = com.baidu.tieba.q.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.q.c.clt().b(this.mPageId, a);
            }
            if (!this.eUH) {
                String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                StringBuilder sb = new StringBuilder();
                if (split.length < 20) {
                    sb.append(string).append("|").append(String.valueOf(this.eUG.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                } else {
                    int i2 = 0;
                    for (String str : split) {
                        if (i2 != 0) {
                            sb.append(str).append("|");
                        }
                        i2++;
                    }
                    sb.append(String.valueOf(this.eUG.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                }
                com.baidu.tbadk.core.sharedPref.b.agM().putString("enter_forum_test_id_list", sb.toString());
            }
            this.eUD.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumTestActivityConfig(getContext(), this.eUG.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.eUC.setIsNight(this.mSkinType == 1);
            al.c(this.eUD, (int) R.drawable.icon_ba_new);
            al.c(this.eUE, (int) R.drawable.icon_ba_close);
            al.j(this.eUF, R.color.cp_cont_b);
            al.k(this.eUF, R.drawable.forum_test_shade_bg);
            al.j(this.bMW, R.color.cp_btn_a);
            al.k(this.bMW, R.drawable.enter_forum_test_shade_bg);
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
