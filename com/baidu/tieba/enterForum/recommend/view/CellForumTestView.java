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
    private TextView ceP;
    private int dce;
    private float fdA;
    private float fdB;
    private float fdC;
    private float fdD;
    private float fdE;
    private float fdF;
    private int fdG;
    private boolean fdH;
    private a fdI;
    private TbImageView fds;
    private ImageView fdt;
    private ImageView fdu;
    private TextView fdv;
    private f fdw;
    private boolean fdx;
    private float fdy;
    private float fdz;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fdx = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fdx = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fdx = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.fds = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.fdt = (ImageView) findViewById(R.id.cell_forum_test_new);
        this.fdu = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.fdv = (TextView) findViewById(R.id.cell_forum_test_des);
        this.ceP = (TextView) findViewById(R.id.cell_forum_test_btn);
        this.fds.setRadius(l.getDimens(context, R.dimen.tbds22));
        this.fds.setConrers(3);
        this.fds.setDefaultBgResource(R.color.cp_atp_a);
        this.fds.setDrawCorner(true);
        this.dce = l.getDimens(context, R.dimen.tbds262);
        this.fdu.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.fdH) {
            this.fds.getLayoutParams().height = this.mHeight - this.dce;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.fdu.setVisibility(0);
        } else {
            this.fdu.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.fdG = i;
    }

    public int getDataIndex() {
        return this.fdG;
    }

    public void setViewLeft(float f) {
        this.fdy = f;
    }

    public float getViewLeft() {
        return this.fdy;
    }

    public void setViewTop(float f) {
        this.fdz = f;
    }

    public float getViewTop() {
        return this.fdz;
    }

    public void setViewRight(float f) {
        this.fdA = f;
    }

    public float getViewRight() {
        return this.fdA;
    }

    public void setViewBottom(float f) {
        this.fdB = f;
    }

    public float getViewBottom() {
        return this.fdB;
    }

    public void setMoveLeft(float f) {
        this.fdC = f;
    }

    public float getMoveLeft() {
        return this.fdC;
    }

    public void setMoveTop(float f) {
        this.fdD = f;
    }

    public float getMoveTop() {
        return this.fdD;
    }

    public void setMoveRight(float f) {
        this.fdE = f;
    }

    public float getMoveRight() {
        return this.fdE;
    }

    public void setMoveBottom(float f) {
        this.fdF = f;
    }

    public float getMoveBottom() {
        return this.fdF;
    }

    public void setIsScale(boolean z) {
        this.fdH = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.fdI = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.fdw = fVar;
            if (fVar.fdo) {
                this.fds.startLoad(fVar.fdp, 10, false);
            } else {
                this.fds.startLoad(fVar.imageUrl, 10, false);
            }
            this.fdx = false;
            String string = com.baidu.tbadk.core.sharedPref.b.alP().getString("enter_forum_test_id_list", "");
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
                        this.fdx = true;
                        break;
                    }
                }
            }
            this.fdt.setVisibility(this.fdx ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.fdv.setText(R.string.cell_forum_test_title_default);
            } else {
                this.fdv.setText(fVar.title);
            }
            if (fVar.fdo) {
                this.ceP.setText(R.string.cell_forum_retest_default);
            } else {
                this.ceP.setText(R.string.cell_forum_test_default);
            }
        }
    }

    public f getData() {
        return this.fdw;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an a;
        if (this.fdu == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new an("c13373").p("uid", TbadkCoreApplication.getCurrentAccountId()).p("obj_id", this.fdw.testId));
                if (this.fdI != null) {
                    this.fdI.pD(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.fdw.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bc.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new an("c13372").p("uid", TbadkCoreApplication.getCurrentAccountId()).p("obj_id", this.fdw.testId));
            int i = this.fdG;
            f fVar = this.fdw;
            if (this.fdw != null && i >= 0 && (a = com.baidu.tieba.q.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.q.c.cni().b(this.mPageId, a);
            }
            if (!this.fdx) {
                String string = com.baidu.tbadk.core.sharedPref.b.alP().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                StringBuilder sb = new StringBuilder();
                if (split.length < 20) {
                    sb.append(string).append("|").append(String.valueOf(this.fdw.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                } else {
                    int i2 = 0;
                    for (String str : split) {
                        if (i2 != 0) {
                            sb.append(str).append("|");
                        }
                        i2++;
                    }
                    sb.append(String.valueOf(this.fdw.testId) + "*" + TbadkCoreApplication.getCurrentAccountId());
                }
                com.baidu.tbadk.core.sharedPref.b.alP().putString("enter_forum_test_id_list", sb.toString());
            }
            this.fdt.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.fdw.testId)));
        }
    }

    public void onChangeSkinType() {
        boolean z = true;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            TbImageView tbImageView = this.fds;
            if (this.mSkinType != 1 && skinType != 4) {
                z = false;
            }
            tbImageView.setIsNight(z);
            am.setImageResource(this.fdt, R.drawable.icon_ba_new);
            am.setImageResource(this.fdu, R.drawable.icon_ba_close);
            am.setViewTextColor(this.fdv, (int) R.color.cp_cont_b);
            am.setBackgroundResource(this.fdv, R.drawable.forum_test_shade_bg);
            am.setViewTextColor(this.ceP, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.ceP, R.drawable.enter_forum_test_shade_bg);
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
