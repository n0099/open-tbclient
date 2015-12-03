package com.baidu.tieba.gift.myGiftList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.gift.myGiftList.a;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private com.baidu.tbadk.core.view.n awY;
    private List<a.C0063a> bwB;
    private MyGiftListActivity bwC;
    private boolean mIsHost;
    private int bwz = 1;
    private int bwA = 14;
    private boolean bwD = false;
    private View.OnClickListener afa = new i(this);

    public h(MyGiftListActivity myGiftListActivity, boolean z) {
        this.bwC = myGiftListActivity;
        this.mIsHost = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bwD) {
            return 1;
        }
        if (this.bwB != null && this.bwB.size() != 0) {
            return this.bwB.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hA */
    public a.C0063a getItem(int i) {
        if (this.bwD) {
            return null;
        }
        int itemId = (int) getItemId(i);
        if (this.bwB == null || this.bwB.size() == 0 || itemId < 0 || itemId >= this.bwB.size()) {
            return null;
        }
        return this.bwB.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.bwz;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.bwD) {
            return createNoDataView();
        }
        if (view == null || view.getTag(n.f.tag_first) == null) {
            view = LayoutInflater.from(this.bwC.getPageContext().getPageActivity()).inflate(n.g.my_gift_list_item, viewGroup, false);
            a aVar2 = new a(null);
            aVar2.boq = (HeadImageView) view.findViewById(n.f.item_portrait);
            aVar2.boq.setOnClickListener(this.afa);
            aVar2.bff = (TextView) view.findViewById(n.f.user_name);
            aVar2.bwH = (TextView) view.findViewById(n.f.gift_num);
            aVar2.bwG = (TbClipImageView) view.findViewById(n.f.gift_icon);
            aVar2.bwF = (TextView) view.findViewById(n.f.gift_name);
            aVar2.aVi = (TextView) view.findViewById(n.f.time);
            aVar2.mSend = (TextView) view.findViewById(n.f.paly_icon);
            view.setTag(n.f.tag_first, aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag(n.f.tag_first);
        }
        if (!this.mIsHost) {
            aVar.aVi.setVisibility(8);
            aVar.mSend.setVisibility(8);
        } else {
            aVar.mSend.setVisibility(0);
        }
        a.C0063a item = getItem(i);
        if (item != null) {
            aVar.boq.d(item.bwk, 28, false);
            aVar.boq.setDrawBorder(false);
            aVar.bff.setText(item.bwj);
            aVar.boq.setTag(n.f.tag_first, Long.valueOf(item.bwi));
            aVar.boq.setTag(n.f.tag_second, item.bwj);
            aVar.bwG.d(item.thumbnailUrl, 10, false);
            aVar.bwF.setText(String.valueOf(this.bwC.getPageContext().getString(n.i.send_to_you)) + com.baidu.tbadk.util.o.w(item.VG, this.bwA));
            aVar.bwG.setDefaultBgResource(n.e.transparent_bg);
            aVar.bwG.setDrawBorder(false);
            if (item.bwm <= 1) {
                aVar.bwH.setVisibility(8);
            } else {
                aVar.bwH.setText(String.valueOf(this.bwC.getPageContext().getString(n.i.mutil_sign)) + item.bwm);
                aVar.bwH.setVisibility(0);
            }
            aVar.aVi.setText(ax.s(item.createTime * 1000));
        }
        applyNightMode(view);
        return view;
    }

    private View createNoDataView() {
        View inflate = LayoutInflater.from(this.bwC.getPageContext().getPageActivity()).inflate(n.g.buy_no_face_item, (ViewGroup) null);
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bwC.getResources().getString(n.i.send_gift), this.bwC.Tt()));
        int dimension = (int) this.bwC.getResources().getDimension(n.d.ds22);
        int dimension2 = (int) this.bwC.getResources().getDimension(n.d.ds140);
        String Tv = this.bwC.Tv();
        String string = this.bwC.getPageContext().getString(n.i.no_gift);
        String string2 = this.bwC.getPageContext().getString(n.i.come_on);
        String format = String.format(this.bwC.getPageContext().getString(n.i.send_him_gift_note), Tv);
        Activity pageActivity = this.bwC.getPageContext().getPageActivity();
        NoDataViewFactory.ImgType imgType = NoDataViewFactory.ImgType.GIFT;
        if (!this.mIsHost) {
            dimension = dimension2;
        }
        this.awY = NoDataViewFactory.a(pageActivity, inflate, NoDataViewFactory.c.a(imgType, dimension), NoDataViewFactory.d.ad(string, this.mIsHost ? string2 : format), (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) ? null : a2);
        int skinType = TbadkApplication.getInst().getSkinType();
        this.bwC.getLayoutMode().af(skinType == 1);
        this.bwC.getLayoutMode().k(inflate);
        this.awY.onChangeSkinType(this.bwC.getPageContext(), skinType);
        this.awY.setVisibility(0);
        return inflate;
    }

    /* loaded from: classes.dex */
    private static class a {
        TextView aVi;
        TextView bff;
        HeadImageView boq;
        TextView bwF;
        TbClipImageView bwG;
        TextView bwH;
        TextView mSend;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    public void setData(List<a.C0063a> list) {
        if (list == null || list.size() <= 0) {
            this.bwD = true;
        } else {
            this.bwD = false;
        }
        this.bwB = list;
        notifyDataSetChanged();
    }

    private void applyNightMode(View view) {
        this.bwC.getLayoutMode().af(TbadkApplication.getInst().getSkinType() == 1);
        this.bwC.getLayoutMode().k(view);
    }
}
