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
    private int cIR;
    private TbImageView eEW;
    private ImageView eEX;
    private ImageView eEY;
    private TextView eEZ;
    private TextView eFa;
    private f eFb;
    private boolean eFc;
    private float eFd;
    private float eFe;
    private float eFf;
    private float eFg;
    private float eFh;
    private float eFi;
    private float eFj;
    private float eFk;
    private int eFl;
    private boolean eFm;
    private a eFn;
    private int mHeight;
    private int mIndex;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eFc = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eFc = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eFc = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.cell_forum_test_layout, (ViewGroup) this, true);
        this.eEW = (TbImageView) findViewById(d.g.cell_forum_test_img);
        this.eEX = (ImageView) findViewById(d.g.cell_forum_test_new);
        this.eEY = (ImageView) findViewById(d.g.cell_forum_test_del);
        this.eEZ = (TextView) findViewById(d.g.cell_forum_test_des);
        this.eFa = (TextView) findViewById(d.g.cell_forum_test_btn);
        this.eEW.setRadius(l.h(context, d.e.tbds22));
        this.eEW.setConrers(3);
        this.eEW.setDefaultBgResource(d.C0277d.cp_atp_a);
        this.eEW.setDrawCorner(true);
        this.cIR = l.h(context, d.e.tbds262);
        this.eEY.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.eFm) {
            this.eEW.getLayoutParams().height = this.mHeight - this.cIR;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.eEY.setVisibility(0);
        } else {
            this.eEY.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.eFl = i;
    }

    public int getDataIndex() {
        return this.eFl;
    }

    public void setViewLeft(float f) {
        this.eFd = f;
    }

    public float getViewLeft() {
        return this.eFd;
    }

    public void setViewTop(float f) {
        this.eFe = f;
    }

    public float getViewTop() {
        return this.eFe;
    }

    public void setViewRight(float f) {
        this.eFf = f;
    }

    public float getViewRight() {
        return this.eFf;
    }

    public void setViewBottom(float f) {
        this.eFg = f;
    }

    public float getViewBottom() {
        return this.eFg;
    }

    public void setMoveLeft(float f) {
        this.eFh = f;
    }

    public float getMoveLeft() {
        return this.eFh;
    }

    public void setMoveTop(float f) {
        this.eFi = f;
    }

    public float getMoveTop() {
        return this.eFi;
    }

    public void setMoveRight(float f) {
        this.eFj = f;
    }

    public float getMoveRight() {
        return this.eFj;
    }

    public void setMoveBottom(float f) {
        this.eFk = f;
    }

    public float getMoveBottom() {
        return this.eFk;
    }

    public void setIsScale(boolean z) {
        this.eFm = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.eFn = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.eFb = fVar;
            if (fVar.eES) {
                this.eEW.startLoad(fVar.eET, 10, false);
            } else {
                this.eEW.startLoad(fVar.imageUrl, 10, false);
            }
            this.eFc = false;
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
                        this.eFc = true;
                        break;
                    }
                }
            }
            this.eEX.setVisibility(this.eFc ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.eEZ.setText(d.j.cell_forum_test_title_default);
            } else {
                this.eEZ.setText(fVar.title);
            }
            if (fVar.eES) {
                this.eFa.setText(d.j.cell_forum_retest_default);
            } else {
                this.eFa.setText(d.j.cell_forum_test_default);
            }
        }
    }

    public f getData() {
        return this.eFb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eEY == view) {
            if (j.kM() && this.mIndex == 1) {
                TiebaStatic.log(new am("c13373").k("uid", TbadkCoreApplication.getCurrentAccountId()).k(VideoPlayActivityConfig.OBJ_ID, this.eFb.testId));
                if (this.eFn != null) {
                    this.eFn.pk(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.eFb.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bc.cZ(getContext())) {
            TiebaStatic.log(new am("c13372").k("uid", TbadkCoreApplication.getCurrentAccountId()).k(VideoPlayActivityConfig.OBJ_ID, this.eFb.testId));
            if (!this.eFc) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                StringBuilder sb = new StringBuilder();
                if (split.length < 20) {
                    sb.append(string).append("|").append(String.valueOf(this.eFb.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                } else {
                    int i = 0;
                    for (String str : split) {
                        if (i != 0) {
                            sb.append(str).append("|");
                        }
                        i++;
                    }
                    sb.append(String.valueOf(this.eFb.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("enter_forum_test_id_list", sb.toString());
            }
            this.eEX.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumTestActivityConfig(getContext(), this.eFb.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.eEW.setIsNight(this.mSkinType == 1);
            al.c(this.eEX, d.f.icon_ba_new);
            al.c(this.eEY, d.f.icon_ba_close);
            al.j(this.eEZ, d.C0277d.cp_cont_b);
            al.k(this.eEZ, d.f.forum_test_shade_bg);
            al.j(this.eFa, d.C0277d.cp_btn_a);
            al.k(this.eFa, d.f.enter_forum_test_shade_bg);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
