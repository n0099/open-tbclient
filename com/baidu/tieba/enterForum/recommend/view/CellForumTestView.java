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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.message.RequestTestCloseMessage;
/* loaded from: classes4.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    private TextView bOC;
    private int cTB;
    private ImageView fbA;
    private TextView fbB;
    private f fbC;
    private boolean fbD;
    private float fbE;
    private float fbF;
    private float fbG;
    private float fbH;
    private float fbI;
    private float fbJ;
    private float fbK;
    private float fbL;
    private int fbM;
    private boolean fbN;
    private a fbO;
    private TbImageView fby;
    private ImageView fbz;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fbD = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fbD = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fbD = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.fby = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.fbz = (ImageView) findViewById(R.id.cell_forum_test_new);
        this.fbA = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.fbB = (TextView) findViewById(R.id.cell_forum_test_des);
        this.bOC = (TextView) findViewById(R.id.cell_forum_test_btn);
        this.fby.setRadius(l.g(context, R.dimen.tbds22));
        this.fby.setConrers(3);
        this.fby.setDefaultBgResource(R.color.cp_atp_a);
        this.fby.setDrawCorner(true);
        this.cTB = l.g(context, R.dimen.tbds262);
        this.fbA.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.fbN) {
            this.fby.getLayoutParams().height = this.mHeight - this.cTB;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.fbA.setVisibility(0);
        } else {
            this.fbA.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.fbM = i;
    }

    public int getDataIndex() {
        return this.fbM;
    }

    public void setViewLeft(float f) {
        this.fbE = f;
    }

    public float getViewLeft() {
        return this.fbE;
    }

    public void setViewTop(float f) {
        this.fbF = f;
    }

    public float getViewTop() {
        return this.fbF;
    }

    public void setViewRight(float f) {
        this.fbG = f;
    }

    public float getViewRight() {
        return this.fbG;
    }

    public void setViewBottom(float f) {
        this.fbH = f;
    }

    public float getViewBottom() {
        return this.fbH;
    }

    public void setMoveLeft(float f) {
        this.fbI = f;
    }

    public float getMoveLeft() {
        return this.fbI;
    }

    public void setMoveTop(float f) {
        this.fbJ = f;
    }

    public float getMoveTop() {
        return this.fbJ;
    }

    public void setMoveRight(float f) {
        this.fbK = f;
    }

    public float getMoveRight() {
        return this.fbK;
    }

    public void setMoveBottom(float f) {
        this.fbL = f;
    }

    public float getMoveBottom() {
        return this.fbL;
    }

    public void setIsScale(boolean z) {
        this.fbN = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.fbO = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.fbC = fVar;
            if (fVar.fbu) {
                this.fby.startLoad(fVar.fbv, 10, false);
            } else {
                this.fby.startLoad(fVar.imageUrl, 10, false);
            }
            this.fbD = false;
            String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("enter_forum_test_id_list", "");
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
                        this.fbD = true;
                        break;
                    }
                }
            }
            this.fbz.setVisibility(this.fbD ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.fbB.setText(R.string.cell_forum_test_title_default);
            } else {
                this.fbB.setText(fVar.title);
            }
            if (fVar.fbu) {
                this.bOC.setText(R.string.cell_forum_retest_default);
            } else {
                this.bOC.setText(R.string.cell_forum_test_default);
            }
        }
    }

    public f getData() {
        return this.fbC;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an a;
        if (this.fbA == view) {
            if (j.jQ() && this.mIndex == 1) {
                TiebaStatic.log(new an("c13373").n("uid", TbadkCoreApplication.getCurrentAccountId()).n(VideoPlayActivityConfig.OBJ_ID, this.fbC.testId));
                if (this.fbO != null) {
                    this.fbO.qI(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.fbC.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bc.cF(getContext())) {
            TiebaStatic.log(new an("c13372").n("uid", TbadkCoreApplication.getCurrentAccountId()).n(VideoPlayActivityConfig.OBJ_ID, this.fbC.testId));
            int i = this.fbM;
            f fVar = this.fbC;
            if (this.fbC != null && i >= 0 && (a = com.baidu.tieba.q.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.q.c.cpt().b(this.mPageId, a);
            }
            if (!this.fbD) {
                String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                StringBuilder sb = new StringBuilder();
                if (split.length < 20) {
                    sb.append(string).append("|").append(String.valueOf(this.fbC.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                } else {
                    int i2 = 0;
                    for (String str : split) {
                        if (i2 != 0) {
                            sb.append(str).append("|");
                        }
                        i2++;
                    }
                    sb.append(String.valueOf(this.fbC.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                }
                com.baidu.tbadk.core.sharedPref.b.ahU().putString("enter_forum_test_id_list", sb.toString());
            }
            this.fbz.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumTestActivityConfig(getContext(), this.fbC.testId)));
        }
    }

    public void onChangeSkinType() {
        boolean z = true;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            TbImageView tbImageView = this.fby;
            if (this.mSkinType != 1 && skinType != 4) {
                z = false;
            }
            tbImageView.setIsNight(z);
            am.c(this.fbz, (int) R.drawable.icon_ba_new);
            am.c(this.fbA, (int) R.drawable.icon_ba_close);
            am.j(this.fbB, R.color.cp_cont_b);
            am.k(this.fbB, R.drawable.forum_test_shade_bg);
            am.j(this.bOC, R.color.cp_cont_a);
            am.k(this.bOC, R.drawable.enter_forum_test_shade_bg);
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
