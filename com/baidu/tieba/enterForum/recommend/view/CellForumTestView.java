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
    private TextView cfG;
    private int dcW;
    private TbImageView fej;
    private ImageView fek;
    private ImageView fel;
    private TextView fem;
    private f fen;
    private boolean feo;
    private float fep;
    private float feq;
    private float fer;
    private float fes;
    private float fet;
    private float feu;
    private float fev;
    private float few;
    private int fex;
    private boolean fey;
    private a fez;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.feo = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.feo = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.feo = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.fej = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.fek = (ImageView) findViewById(R.id.cell_forum_test_new);
        this.fel = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.fem = (TextView) findViewById(R.id.cell_forum_test_des);
        this.cfG = (TextView) findViewById(R.id.cell_forum_test_btn);
        this.fej.setRadius(l.getDimens(context, R.dimen.tbds22));
        this.fej.setConrers(3);
        this.fej.setDefaultBgResource(R.color.cp_atp_a);
        this.fej.setDrawCorner(true);
        this.dcW = l.getDimens(context, R.dimen.tbds262);
        this.fel.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.fey) {
            this.fej.getLayoutParams().height = this.mHeight - this.dcW;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.fel.setVisibility(0);
        } else {
            this.fel.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.fex = i;
    }

    public int getDataIndex() {
        return this.fex;
    }

    public void setViewLeft(float f) {
        this.fep = f;
    }

    public float getViewLeft() {
        return this.fep;
    }

    public void setViewTop(float f) {
        this.feq = f;
    }

    public float getViewTop() {
        return this.feq;
    }

    public void setViewRight(float f) {
        this.fer = f;
    }

    public float getViewRight() {
        return this.fer;
    }

    public void setViewBottom(float f) {
        this.fes = f;
    }

    public float getViewBottom() {
        return this.fes;
    }

    public void setMoveLeft(float f) {
        this.fet = f;
    }

    public float getMoveLeft() {
        return this.fet;
    }

    public void setMoveTop(float f) {
        this.feu = f;
    }

    public float getMoveTop() {
        return this.feu;
    }

    public void setMoveRight(float f) {
        this.fev = f;
    }

    public float getMoveRight() {
        return this.fev;
    }

    public void setMoveBottom(float f) {
        this.few = f;
    }

    public float getMoveBottom() {
        return this.few;
    }

    public void setIsScale(boolean z) {
        this.fey = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.fez = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.fen = fVar;
            if (fVar.fef) {
                this.fej.startLoad(fVar.feg, 10, false);
            } else {
                this.fej.startLoad(fVar.imageUrl, 10, false);
            }
            this.feo = false;
            String string = com.baidu.tbadk.core.sharedPref.b.alR().getString("enter_forum_test_id_list", "");
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
                        this.feo = true;
                        break;
                    }
                }
            }
            this.fek.setVisibility(this.feo ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.fem.setText(R.string.cell_forum_test_title_default);
            } else {
                this.fem.setText(fVar.title);
            }
            if (fVar.fef) {
                this.cfG.setText(R.string.cell_forum_retest_default);
            } else {
                this.cfG.setText(R.string.cell_forum_test_default);
            }
        }
    }

    public f getData() {
        return this.fen;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an a;
        if (this.fel == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new an("c13373").p("uid", TbadkCoreApplication.getCurrentAccountId()).p("obj_id", this.fen.testId));
                if (this.fez != null) {
                    this.fez.pE(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.fen.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bc.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new an("c13372").p("uid", TbadkCoreApplication.getCurrentAccountId()).p("obj_id", this.fen.testId));
            int i = this.fex;
            f fVar = this.fen;
            if (this.fen != null && i >= 0 && (a = com.baidu.tieba.q.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.q.c.cnk().b(this.mPageId, a);
            }
            if (!this.feo) {
                String string = com.baidu.tbadk.core.sharedPref.b.alR().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                StringBuilder sb = new StringBuilder();
                if (split.length < 20) {
                    sb.append(string).append("|").append(String.valueOf(this.fen.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                } else {
                    int i2 = 0;
                    for (String str : split) {
                        if (i2 != 0) {
                            sb.append(str).append("|");
                        }
                        i2++;
                    }
                    sb.append(String.valueOf(this.fen.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                }
                com.baidu.tbadk.core.sharedPref.b.alR().putString("enter_forum_test_id_list", sb.toString());
            }
            this.fek.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.fen.testId)));
        }
    }

    public void onChangeSkinType() {
        boolean z = true;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            TbImageView tbImageView = this.fej;
            if (this.mSkinType != 1 && skinType != 4) {
                z = false;
            }
            tbImageView.setIsNight(z);
            am.setImageResource(this.fek, R.drawable.icon_ba_new);
            am.setImageResource(this.fel, R.drawable.icon_ba_close);
            am.setViewTextColor(this.fem, (int) R.color.cp_cont_b);
            am.setBackgroundResource(this.fem, R.drawable.forum_test_shade_bg);
            am.setViewTextColor(this.cfG, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.cfG, R.drawable.enter_forum_test_shade_bg);
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
