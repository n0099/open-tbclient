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
    private TextView bOd;
    private int cSI;
    private TbImageView eZS;
    private ImageView eZT;
    private ImageView eZU;
    private TextView eZV;
    private f eZW;
    private boolean eZX;
    private float eZY;
    private float eZZ;
    private float faa;
    private float fab;
    private float fac;
    private float fad;
    private float fae;
    private float faf;
    private int fag;
    private boolean fah;
    private a fai;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eZX = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eZX = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eZX = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.eZS = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.eZT = (ImageView) findViewById(R.id.cell_forum_test_new);
        this.eZU = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.eZV = (TextView) findViewById(R.id.cell_forum_test_des);
        this.bOd = (TextView) findViewById(R.id.cell_forum_test_btn);
        this.eZS.setRadius(l.g(context, R.dimen.tbds22));
        this.eZS.setConrers(3);
        this.eZS.setDefaultBgResource(R.color.cp_atp_a);
        this.eZS.setDrawCorner(true);
        this.cSI = l.g(context, R.dimen.tbds262);
        this.eZU.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.fah) {
            this.eZS.getLayoutParams().height = this.mHeight - this.cSI;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.eZU.setVisibility(0);
        } else {
            this.eZU.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.fag = i;
    }

    public int getDataIndex() {
        return this.fag;
    }

    public void setViewLeft(float f) {
        this.eZY = f;
    }

    public float getViewLeft() {
        return this.eZY;
    }

    public void setViewTop(float f) {
        this.eZZ = f;
    }

    public float getViewTop() {
        return this.eZZ;
    }

    public void setViewRight(float f) {
        this.faa = f;
    }

    public float getViewRight() {
        return this.faa;
    }

    public void setViewBottom(float f) {
        this.fab = f;
    }

    public float getViewBottom() {
        return this.fab;
    }

    public void setMoveLeft(float f) {
        this.fac = f;
    }

    public float getMoveLeft() {
        return this.fac;
    }

    public void setMoveTop(float f) {
        this.fad = f;
    }

    public float getMoveTop() {
        return this.fad;
    }

    public void setMoveRight(float f) {
        this.fae = f;
    }

    public float getMoveRight() {
        return this.fae;
    }

    public void setMoveBottom(float f) {
        this.faf = f;
    }

    public float getMoveBottom() {
        return this.faf;
    }

    public void setIsScale(boolean z) {
        this.fah = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.fai = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.eZW = fVar;
            if (fVar.eZO) {
                this.eZS.startLoad(fVar.eZP, 10, false);
            } else {
                this.eZS.startLoad(fVar.imageUrl, 10, false);
            }
            this.eZX = false;
            String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("enter_forum_test_id_list", "");
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
                        this.eZX = true;
                        break;
                    }
                }
            }
            this.eZT.setVisibility(this.eZX ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.eZV.setText(R.string.cell_forum_test_title_default);
            } else {
                this.eZV.setText(fVar.title);
            }
            if (fVar.eZO) {
                this.bOd.setText(R.string.cell_forum_retest_default);
            } else {
                this.bOd.setText(R.string.cell_forum_test_default);
            }
        }
    }

    public f getData() {
        return this.eZW;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an a;
        if (this.eZU == view) {
            if (j.jQ() && this.mIndex == 1) {
                TiebaStatic.log(new an("c13373").l("uid", TbadkCoreApplication.getCurrentAccountId()).l(VideoPlayActivityConfig.OBJ_ID, this.eZW.testId));
                if (this.fai != null) {
                    this.fai.qF(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.eZW.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bd.cF(getContext())) {
            TiebaStatic.log(new an("c13372").l("uid", TbadkCoreApplication.getCurrentAccountId()).l(VideoPlayActivityConfig.OBJ_ID, this.eZW.testId));
            int i = this.fag;
            f fVar = this.eZW;
            if (this.eZW != null && i >= 0 && (a = com.baidu.tieba.q.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.q.c.coG().b(this.mPageId, a);
            }
            if (!this.eZX) {
                String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                StringBuilder sb = new StringBuilder();
                if (split.length < 20) {
                    sb.append(string).append("|").append(String.valueOf(this.eZW.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                } else {
                    int i2 = 0;
                    for (String str : split) {
                        if (i2 != 0) {
                            sb.append(str).append("|");
                        }
                        i2++;
                    }
                    sb.append(String.valueOf(this.eZW.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                }
                com.baidu.tbadk.core.sharedPref.b.ahQ().putString("enter_forum_test_id_list", sb.toString());
            }
            this.eZT.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumTestActivityConfig(getContext(), this.eZW.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.eZS.setIsNight(this.mSkinType == 1);
            am.c(this.eZT, (int) R.drawable.icon_ba_new);
            am.c(this.eZU, (int) R.drawable.icon_ba_close);
            am.j(this.eZV, R.color.cp_cont_b);
            am.k(this.eZV, R.drawable.forum_test_shade_bg);
            am.j(this.bOd, R.color.cp_btn_a);
            am.k(this.bOd, R.drawable.enter_forum_test_shade_bg);
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
