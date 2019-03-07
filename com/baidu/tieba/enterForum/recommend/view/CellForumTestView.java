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
    private TbImageView eFa;
    private ImageView eFb;
    private ImageView eFc;
    private TextView eFd;
    private TextView eFe;
    private f eFf;
    private boolean eFg;
    private float eFh;
    private float eFi;
    private float eFj;
    private float eFk;
    private float eFl;
    private float eFm;
    private float eFn;
    private float eFo;
    private int eFp;
    private boolean eFq;
    private a eFr;
    private int mHeight;
    private int mIndex;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eFg = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eFg = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eFg = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.cell_forum_test_layout, (ViewGroup) this, true);
        this.eFa = (TbImageView) findViewById(d.g.cell_forum_test_img);
        this.eFb = (ImageView) findViewById(d.g.cell_forum_test_new);
        this.eFc = (ImageView) findViewById(d.g.cell_forum_test_del);
        this.eFd = (TextView) findViewById(d.g.cell_forum_test_des);
        this.eFe = (TextView) findViewById(d.g.cell_forum_test_btn);
        this.eFa.setRadius(l.h(context, d.e.tbds22));
        this.eFa.setConrers(3);
        this.eFa.setDefaultBgResource(d.C0236d.cp_atp_a);
        this.eFa.setDrawCorner(true);
        this.cIU = l.h(context, d.e.tbds262);
        this.eFc.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.eFq) {
            this.eFa.getLayoutParams().height = this.mHeight - this.cIU;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.eFc.setVisibility(0);
        } else {
            this.eFc.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.eFp = i;
    }

    public int getDataIndex() {
        return this.eFp;
    }

    public void setViewLeft(float f) {
        this.eFh = f;
    }

    public float getViewLeft() {
        return this.eFh;
    }

    public void setViewTop(float f) {
        this.eFi = f;
    }

    public float getViewTop() {
        return this.eFi;
    }

    public void setViewRight(float f) {
        this.eFj = f;
    }

    public float getViewRight() {
        return this.eFj;
    }

    public void setViewBottom(float f) {
        this.eFk = f;
    }

    public float getViewBottom() {
        return this.eFk;
    }

    public void setMoveLeft(float f) {
        this.eFl = f;
    }

    public float getMoveLeft() {
        return this.eFl;
    }

    public void setMoveTop(float f) {
        this.eFm = f;
    }

    public float getMoveTop() {
        return this.eFm;
    }

    public void setMoveRight(float f) {
        this.eFn = f;
    }

    public float getMoveRight() {
        return this.eFn;
    }

    public void setMoveBottom(float f) {
        this.eFo = f;
    }

    public float getMoveBottom() {
        return this.eFo;
    }

    public void setIsScale(boolean z) {
        this.eFq = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.eFr = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.eFf = fVar;
            if (fVar.eEW) {
                this.eFa.startLoad(fVar.eEX, 10, false);
            } else {
                this.eFa.startLoad(fVar.imageUrl, 10, false);
            }
            this.eFg = false;
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
                        this.eFg = true;
                        break;
                    }
                }
            }
            this.eFb.setVisibility(this.eFg ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.eFd.setText(d.j.cell_forum_test_title_default);
            } else {
                this.eFd.setText(fVar.title);
            }
            if (fVar.eEW) {
                this.eFe.setText(d.j.cell_forum_retest_default);
            } else {
                this.eFe.setText(d.j.cell_forum_test_default);
            }
        }
    }

    public f getData() {
        return this.eFf;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eFc == view) {
            if (j.kM() && this.mIndex == 1) {
                TiebaStatic.log(new am("c13373").k("uid", TbadkCoreApplication.getCurrentAccountId()).k(VideoPlayActivityConfig.OBJ_ID, this.eFf.testId));
                if (this.eFr != null) {
                    this.eFr.pk(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.eFf.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bc.cZ(getContext())) {
            TiebaStatic.log(new am("c13372").k("uid", TbadkCoreApplication.getCurrentAccountId()).k(VideoPlayActivityConfig.OBJ_ID, this.eFf.testId));
            if (!this.eFg) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                StringBuilder sb = new StringBuilder();
                if (split.length < 20) {
                    sb.append(string).append("|").append(String.valueOf(this.eFf.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                } else {
                    int i = 0;
                    for (String str : split) {
                        if (i != 0) {
                            sb.append(str).append("|");
                        }
                        i++;
                    }
                    sb.append(String.valueOf(this.eFf.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("enter_forum_test_id_list", sb.toString());
            }
            this.eFb.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumTestActivityConfig(getContext(), this.eFf.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.eFa.setIsNight(this.mSkinType == 1);
            al.c(this.eFb, d.f.icon_ba_new);
            al.c(this.eFc, d.f.icon_ba_close);
            al.j(this.eFd, d.C0236d.cp_cont_b);
            al.k(this.eFd, d.f.forum_test_shade_bg);
            al.j(this.eFe, d.C0236d.cp_btn_a);
            al.k(this.eFe, d.f.enter_forum_test_shade_bg);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
