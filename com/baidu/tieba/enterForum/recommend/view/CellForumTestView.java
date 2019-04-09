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
    private int cIU;
    private TbImageView eEI;
    private ImageView eEJ;
    private ImageView eEK;
    private TextView eEL;
    private TextView eEM;
    private f eEN;
    private boolean eEO;
    private float eEP;
    private float eEQ;
    private float eER;
    private float eES;
    private float eET;
    private float eEU;
    private float eEV;
    private float eEW;
    private int eEX;
    private boolean eEY;
    private a eEZ;
    private int mHeight;
    private int mIndex;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eEO = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eEO = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eEO = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.cell_forum_test_layout, (ViewGroup) this, true);
        this.eEI = (TbImageView) findViewById(d.g.cell_forum_test_img);
        this.eEJ = (ImageView) findViewById(d.g.cell_forum_test_new);
        this.eEK = (ImageView) findViewById(d.g.cell_forum_test_del);
        this.eEL = (TextView) findViewById(d.g.cell_forum_test_des);
        this.eEM = (TextView) findViewById(d.g.cell_forum_test_btn);
        this.eEI.setRadius(l.h(context, d.e.tbds22));
        this.eEI.setConrers(3);
        this.eEI.setDefaultBgResource(d.C0277d.cp_atp_a);
        this.eEI.setDrawCorner(true);
        this.cIU = l.h(context, d.e.tbds262);
        this.eEK.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.eEY) {
            this.eEI.getLayoutParams().height = this.mHeight - this.cIU;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.eEK.setVisibility(0);
        } else {
            this.eEK.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.eEX = i;
    }

    public int getDataIndex() {
        return this.eEX;
    }

    public void setViewLeft(float f) {
        this.eEP = f;
    }

    public float getViewLeft() {
        return this.eEP;
    }

    public void setViewTop(float f) {
        this.eEQ = f;
    }

    public float getViewTop() {
        return this.eEQ;
    }

    public void setViewRight(float f) {
        this.eER = f;
    }

    public float getViewRight() {
        return this.eER;
    }

    public void setViewBottom(float f) {
        this.eES = f;
    }

    public float getViewBottom() {
        return this.eES;
    }

    public void setMoveLeft(float f) {
        this.eET = f;
    }

    public float getMoveLeft() {
        return this.eET;
    }

    public void setMoveTop(float f) {
        this.eEU = f;
    }

    public float getMoveTop() {
        return this.eEU;
    }

    public void setMoveRight(float f) {
        this.eEV = f;
    }

    public float getMoveRight() {
        return this.eEV;
    }

    public void setMoveBottom(float f) {
        this.eEW = f;
    }

    public float getMoveBottom() {
        return this.eEW;
    }

    public void setIsScale(boolean z) {
        this.eEY = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.eEZ = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.eEN = fVar;
            if (fVar.eEE) {
                this.eEI.startLoad(fVar.eEF, 10, false);
            } else {
                this.eEI.startLoad(fVar.imageUrl, 10, false);
            }
            this.eEO = false;
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
                        this.eEO = true;
                        break;
                    }
                }
            }
            this.eEJ.setVisibility(this.eEO ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.eEL.setText(d.j.cell_forum_test_title_default);
            } else {
                this.eEL.setText(fVar.title);
            }
            if (fVar.eEE) {
                this.eEM.setText(d.j.cell_forum_retest_default);
            } else {
                this.eEM.setText(d.j.cell_forum_test_default);
            }
        }
    }

    public f getData() {
        return this.eEN;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eEK == view) {
            if (j.kM() && this.mIndex == 1) {
                TiebaStatic.log(new am("c13373").k("uid", TbadkCoreApplication.getCurrentAccountId()).k(VideoPlayActivityConfig.OBJ_ID, this.eEN.testId));
                if (this.eEZ != null) {
                    this.eEZ.pg(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.eEN.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bc.cZ(getContext())) {
            TiebaStatic.log(new am("c13372").k("uid", TbadkCoreApplication.getCurrentAccountId()).k(VideoPlayActivityConfig.OBJ_ID, this.eEN.testId));
            if (!this.eEO) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                StringBuilder sb = new StringBuilder();
                if (split.length < 20) {
                    sb.append(string).append("|").append(String.valueOf(this.eEN.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                } else {
                    int i = 0;
                    for (String str : split) {
                        if (i != 0) {
                            sb.append(str).append("|");
                        }
                        i++;
                    }
                    sb.append(String.valueOf(this.eEN.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("enter_forum_test_id_list", sb.toString());
            }
            this.eEJ.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumTestActivityConfig(getContext(), this.eEN.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.eEI.setIsNight(this.mSkinType == 1);
            al.c(this.eEJ, d.f.icon_ba_new);
            al.c(this.eEK, d.f.icon_ba_close);
            al.j(this.eEL, d.C0277d.cp_cont_b);
            al.k(this.eEL, d.f.forum_test_shade_bg);
            al.j(this.eEM, d.C0277d.cp_btn_a);
            al.k(this.eEM, d.f.enter_forum_test_shade_bg);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
