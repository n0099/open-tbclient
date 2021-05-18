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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumTestActivityConfig;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbCornersImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.message.RequestTestCloseMessage;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.j0.r.d0.b;
import d.a.k0.c3.c;
import d.a.k0.i0.k.c.f;
import d.a.k0.i0.k.d.a;
/* loaded from: classes4.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    public boolean A;
    public a B;

    /* renamed from: e  reason: collision with root package name */
    public int f14609e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f14610f;

    /* renamed from: g  reason: collision with root package name */
    public TbCornersImageView f14611g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f14612h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f14613i;
    public TBSpecificationBtn j;
    public int k;
    public int l;
    public int m;
    public BdUniqueId n;
    public f o;
    public boolean p;
    public float q;
    public float r;
    public float s;
    public float t;
    public float u;
    public float v;
    public float w;
    public float x;
    public int y;
    public int z;

    public CellForumTestView(Context context) {
        super(context);
        this.f14609e = 3;
        this.p = false;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.f14610f = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.f14611g = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.f14612h = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.f14613i = (TextView) findViewById(R.id.cell_forum_test_des);
        this.j = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        d.a.j0.r.f0.m.a aVar = new d.a.j0.r.f0.m.a();
        this.j.setTextSize(R.dimen.tbds42);
        this.j.setConfig(aVar);
        int g2 = l.g(context, R.dimen.tbds10);
        this.f14611g.setCornerTopLeftRadius(g2);
        this.f14610f.setRadius(g2);
        this.f14610f.setConrers(3);
        this.f14610f.setPlaceHolder(3);
        this.f14610f.setDrawCorner(true);
        this.m = l.g(context, R.dimen.tbds262);
        this.f14612h.setOnClickListener(this);
        setOnClickListener(this);
        b();
    }

    public void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f14609e) {
            return;
        }
        this.f14609e = skinType;
        TbImageView tbImageView = this.f14610f;
        if (tbImageView != null) {
            tbImageView.setIsNight(skinType == 1 || skinType == 4);
        }
        TBSpecificationBtn tBSpecificationBtn = this.j;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f14611g, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
        if (skinType != 1 && skinType != 4) {
            ((ViewGroup.MarginLayoutParams) this.f14613i.getLayoutParams()).setMargins(0, 0, 0, 0);
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(l.g(getContext(), R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.NO_TOP).setShadowRadius(l.g(getContext(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(getContext(), R.dimen.tbds5)).into(this.f14613i);
        } else {
            ((ViewGroup.MarginLayoutParams) this.f14613i.getLayoutParams()).setMargins(l.g(getContext(), R.dimen.tbds4), 0, l.g(getContext(), R.dimen.tbds9), 0);
            float g2 = l.g(getContext(), R.dimen.tbds10);
            TBSelector.makeDrawableSelector().blRadius(g2).brRadius(g2).defaultColor(R.color.CAM_X0207).into(this.f14613i);
        }
        SkinManager.setImageResource(this.f14612h, R.drawable.icon_ba_close);
        SkinManager.setViewTextColor(this.f14613i, R.color.CAM_X0105);
    }

    public f getData() {
        return this.o;
    }

    public int getDataIndex() {
        return this.z;
    }

    public int getIndex() {
        return this.y;
    }

    public float getMoveBottom() {
        return this.x;
    }

    public float getMoveLeft() {
        return this.u;
    }

    public float getMoveRight() {
        return this.w;
    }

    public float getMoveTop() {
        return this.v;
    }

    public float getViewBottom() {
        return this.t;
    }

    public float getViewLeft() {
        return this.q;
    }

    public float getViewRight() {
        return this.s;
    }

    public float getViewTop() {
        return this.r;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2;
        StatisticItem l;
        if (this.f14612h == view) {
            if (j.A() && this.y == 1) {
                TiebaStatic.log(new StatisticItem("c13373").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", this.o.f55837a));
                a aVar = this.B;
                if (aVar != null) {
                    aVar.a(this.y);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.o.f55837a);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (ViewHelper.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new StatisticItem("c13372").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", this.o.f55837a));
            int i3 = this.z;
            f fVar = this.o;
            if (fVar != null && i3 >= 0 && (l = d.a.k0.c3.a.l(true, "a065", "common_click", i2, (i2 = i3 + 1), false, null, String.valueOf(fVar.f55837a), 0)) != null) {
                c.g().c(this.n, l);
            }
            if (!this.p) {
                String p = b.j().p("enter_forum_test_id_list", "");
                String[] split = p.split("[|]");
                String str = this.o.f55837a + "*" + TbadkCoreApplication.getCurrentAccountId();
                StringBuilder sb = new StringBuilder();
                if (split.length < 20) {
                    sb.append(p);
                    sb.append(FieldBuilder.SE);
                    sb.append(str);
                } else {
                    int i4 = 0;
                    for (String str2 : split) {
                        if (i4 != 0) {
                            sb.append(str2);
                            sb.append(FieldBuilder.SE);
                        }
                        i4++;
                    }
                    sb.append(str);
                }
                b.j().x("enter_forum_test_id_list", sb.toString());
            }
            this.f14611g.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumTestActivityConfig(getContext(), this.o.f55837a)));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        this.k = View.MeasureSpec.getSize(i2);
        this.l = View.MeasureSpec.getSize(i3);
        if (!this.A) {
            this.f14610f.getLayoutParams().height = this.l - this.m;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.k, 1073741824), View.MeasureSpec.makeMeasureSpec(this.l, 1073741824));
    }

    public void setData(f fVar) {
        if (fVar == null) {
            return;
        }
        this.o = fVar;
        this.f14610f.V(fVar.f55840d ? fVar.f55841e : fVar.f55839c, 10, false);
        this.p = false;
        String p = b.j().p("enter_forum_test_id_list", "");
        String[] split = p.split("[|]");
        if (!StringUtils.isNull(p)) {
            int length = split.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                String str = split[i2];
                if (!StringUtils.isNull(str)) {
                    if (str.equals(fVar.f55837a + "*" + TbadkCoreApplication.getCurrentAccountId())) {
                        this.p = true;
                        break;
                    }
                }
                i2++;
            }
        }
        this.f14611g.setVisibility(this.p ? 8 : 0);
        if (StringUtils.isNull(fVar.f55838b)) {
            this.f14613i.setText(R.string.cell_forum_test_title_default);
        } else {
            this.f14613i.setText(fVar.f55838b);
        }
        this.j.setText(getResources().getString(fVar.f55840d ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
    }

    public void setDataIndex(int i2) {
        this.z = i2;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.B = aVar;
    }

    public void setIndex(int i2) {
        this.y = i2;
        if (i2 == 1) {
            this.f14612h.setVisibility(0);
        } else {
            this.f14612h.setVisibility(8);
        }
    }

    public void setIsScale(boolean z) {
        this.A = z;
    }

    public void setMoveBottom(float f2) {
        this.x = f2;
    }

    public void setMoveLeft(float f2) {
        this.u = f2;
    }

    public void setMoveRight(float f2) {
        this.w = f2;
    }

    public void setMoveTop(float f2) {
        this.v = f2;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.n = bdUniqueId;
    }

    public void setViewBottom(float f2) {
        this.t = f2;
    }

    public void setViewLeft(float f2) {
        this.q = f2;
    }

    public void setViewRight(float f2) {
        this.s = f2;
    }

    public void setViewTop(float f2) {
        this.r = f2;
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14609e = 3;
        this.p = false;
        a(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14609e = 3;
        this.p = false;
        a(context);
    }
}
