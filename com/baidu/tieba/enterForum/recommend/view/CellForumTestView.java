package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.message.RequestTestCloseMessage;
/* loaded from: classes4.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    private int cIT;
    private TbImageView eEH;
    private ImageView eEI;
    private ImageView eEJ;
    private TextView eEK;
    private TextView eEL;
    private f eEM;
    private boolean eEN;
    private float eEO;
    private float eEP;
    private float eEQ;
    private float eER;
    private float eES;
    private float eET;
    private float eEU;
    private float eEV;
    private int eEW;
    private boolean eEX;
    private a eEY;
    private int mHeight;
    private int mIndex;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eEN = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eEN = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eEN = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.cell_forum_test_layout, (ViewGroup) this, true);
        this.eEH = (TbImageView) findViewById(d.g.cell_forum_test_img);
        this.eEI = (ImageView) findViewById(d.g.cell_forum_test_new);
        this.eEJ = (ImageView) findViewById(d.g.cell_forum_test_del);
        this.eEK = (TextView) findViewById(d.g.cell_forum_test_des);
        this.eEL = (TextView) findViewById(d.g.cell_forum_test_btn);
        this.eEH.setRadius(l.h(context, d.e.tbds22));
        this.eEH.setConrers(3);
        this.eEH.setDefaultBgResource(d.C0277d.cp_atp_a);
        this.eEH.setDrawCorner(true);
        this.cIT = l.h(context, d.e.tbds262);
        this.eEJ.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.eEX) {
            this.eEH.getLayoutParams().height = this.mHeight - this.cIT;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.eEJ.setVisibility(0);
        } else {
            this.eEJ.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.eEW = i;
    }

    public int getDataIndex() {
        return this.eEW;
    }

    public void setViewLeft(float f) {
        this.eEO = f;
    }

    public float getViewLeft() {
        return this.eEO;
    }

    public void setViewTop(float f) {
        this.eEP = f;
    }

    public float getViewTop() {
        return this.eEP;
    }

    public void setViewRight(float f) {
        this.eEQ = f;
    }

    public float getViewRight() {
        return this.eEQ;
    }

    public void setViewBottom(float f) {
        this.eER = f;
    }

    public float getViewBottom() {
        return this.eER;
    }

    public void setMoveLeft(float f) {
        this.eES = f;
    }

    public float getMoveLeft() {
        return this.eES;
    }

    public void setMoveTop(float f) {
        this.eET = f;
    }

    public float getMoveTop() {
        return this.eET;
    }

    public void setMoveRight(float f) {
        this.eEU = f;
    }

    public float getMoveRight() {
        return this.eEU;
    }

    public void setMoveBottom(float f) {
        this.eEV = f;
    }

    public float getMoveBottom() {
        return this.eEV;
    }

    public void setIsScale(boolean z) {
        this.eEX = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.eEY = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.eEM = fVar;
            if (fVar.eED) {
                this.eEH.startLoad(fVar.eEE, 10, false);
            } else {
                this.eEH.startLoad(fVar.imageUrl, 10, false);
            }
            this.eEN = false;
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("enter_forum_test_id_list", "");
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
                        this.eEN = true;
                        break;
                    }
                }
            }
            this.eEI.setVisibility(this.eEN ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.eEK.setText(d.j.cell_forum_test_title_default);
            } else {
                this.eEK.setText(fVar.title);
            }
            if (fVar.eED) {
                this.eEL.setText(d.j.cell_forum_retest_default);
            } else {
                this.eEL.setText(d.j.cell_forum_test_default);
            }
        }
    }

    public f getData() {
        return this.eEM;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eEJ == view) {
            if (j.kM() && this.mIndex == 1) {
                TiebaStatic.log(new am("c13373").k("uid", TbadkCoreApplication.getCurrentAccountId()).k(VideoPlayActivityConfig.OBJ_ID, this.eEM.testId));
                if (this.eEY != null) {
                    this.eEY.pg(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.eEM.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bc.cZ(getContext())) {
            TiebaStatic.log(new am("c13372").k("uid", TbadkCoreApplication.getCurrentAccountId()).k(VideoPlayActivityConfig.OBJ_ID, this.eEM.testId));
            if (!this.eEN) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                StringBuilder sb = new StringBuilder();
                if (split.length < 20) {
                    sb.append(string).append("|").append(String.valueOf(this.eEM.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                } else {
                    int i = 0;
                    for (String str : split) {
                        if (i != 0) {
                            sb.append(str).append("|");
                        }
                        i++;
                    }
                    sb.append(String.valueOf(this.eEM.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("enter_forum_test_id_list", sb.toString());
            }
            this.eEI.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumTestActivityConfig(getContext(), this.eEM.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.eEH.setIsNight(this.mSkinType == 1);
            al.c(this.eEI, d.f.icon_ba_new);
            al.c(this.eEJ, d.f.icon_ba_close);
            al.j(this.eEK, d.C0277d.cp_cont_b);
            al.k(this.eEK, d.f.forum_test_shade_bg);
            al.j(this.eEL, d.C0277d.cp_btn_a);
            al.k(this.eEL, d.f.enter_forum_test_shade_bg);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
