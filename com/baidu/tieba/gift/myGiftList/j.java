package com.baidu.tieba.gift.myGiftList;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.i;
import java.util.List;
import tbclient.GetGiftMyList.GiftList;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    private com.baidu.tbadk.core.view.m auU;
    private List<GiftList> bnE;
    private MyGiftListActivity bnF;
    private boolean mIsHost;
    private int bnD = 1;
    private boolean bnG = false;
    private String bnH = null;
    View.OnClickListener aed = new k(this);

    public j(MyGiftListActivity myGiftListActivity, boolean z) {
        this.bnF = myGiftListActivity;
        this.mIsHost = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bnG) {
            return 1;
        }
        if (this.bnE != null && this.bnE.size() != 0) {
            return this.bnE.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gQ */
    public GiftList getItem(int i) {
        if (this.bnG) {
            return null;
        }
        int itemId = (int) getItemId(i);
        if (this.bnE == null || this.bnE.size() == 0 || itemId < 0 || itemId >= this.bnE.size()) {
            return null;
        }
        return this.bnE.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.bnD;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.bnG) {
            return createNoDataView();
        }
        if (view == null || view.getTag(i.f.tag_first) == null) {
            view = LayoutInflater.from(this.bnF.getPageContext().getPageActivity()).inflate(i.g.my_gift_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.bhp = (HeadImageView) view.findViewById(i.f.item_portrait);
            aVar2.bhp.setOnClickListener(this.aed);
            aVar2.aZd = (TextView) view.findViewById(i.f.user_name);
            aVar2.bnL = (TextView) view.findViewById(i.f.gift_num);
            aVar2.bnK = (TbClipImageView) view.findViewById(i.f.gift_icon);
            aVar2.bnJ = (TextView) view.findViewById(i.f.gift_name);
            aVar2.aQf = (TextView) view.findViewById(i.f.time);
            aVar2.bnM = (TextView) view.findViewById(i.f.paly_icon);
            view.setTag(i.f.tag_first, aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag(i.f.tag_first);
        }
        if (!this.mIsHost) {
            aVar.aQf.setVisibility(8);
        }
        GiftList item = getItem(i);
        if (item.sender != null) {
            aVar.bhp.d(item.sender.portrait, 28, false);
            aVar.bhp.setAutoChangeStyle(false);
            aVar.bhp.setDrawBorder(false);
            aVar.aZd.setText(item.sender.name_show);
            aVar.bhp.setTag(i.f.tag_first, item.sender.id);
            aVar.bhp.setTag(i.f.tag_second, item.sender.name_show);
        }
        if (item.gift != null) {
            aVar.bnK.d(item.gift.thumbnail_url, 10, false);
            aVar.bnJ.setText(String.valueOf(this.bnF.getPageContext().getString(i.h.send_to_you)) + item.gift.name);
            aVar.bnK.setAutoChangeStyle(false);
            aVar.bnK.setDrawBorder(false);
            aVar.bnL.setText(String.valueOf(this.bnF.getPageContext().getString(i.h.mutil_sign)) + item.gift.num);
            aVar.aQf.setText(as.m(item.gift.send_time.intValue() * 1000));
            this.bnH = item.gift.play_url;
            boolean isEmpty = TextUtils.isEmpty(this.bnH);
            if (this.mIsHost && !isEmpty && com.baidu.adp.lib.util.k.jh()) {
                aVar.bnM.setVisibility(0);
            } else {
                aVar.bnM.setVisibility(8);
            }
        }
        applyNightMode(view);
        if (com.baidu.adp.lib.util.k.jh()) {
            view.setTag(i.f.tag_second, this.bnH);
            return view;
        }
        return view;
    }

    private View createNoDataView() {
        View inflate = LayoutInflater.from(this.bnF.getPageContext().getPageActivity()).inflate(i.g.buy_no_face_item, (ViewGroup) null);
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bnF.getResources().getString(i.h.send_gift), this.bnF.QN()));
        int dimension = (int) this.bnF.getResources().getDimension(i.d.ds22);
        int dimension2 = (int) this.bnF.getResources().getDimension(i.d.ds140);
        String QP = this.bnF.QP();
        String string = this.bnF.getPageContext().getString(i.h.no_gift);
        String string2 = this.bnF.getPageContext().getString(i.h.come_on);
        String format = String.format(this.bnF.getPageContext().getString(i.h.send_him_gift_note), QP);
        Activity pageActivity = this.bnF.getPageContext().getPageActivity();
        NoDataViewFactory.ImgType imgType = NoDataViewFactory.ImgType.GIFT;
        if (!this.mIsHost) {
            dimension = dimension2;
        }
        this.auU = NoDataViewFactory.a(pageActivity, inflate, NoDataViewFactory.c.a(imgType, dimension), NoDataViewFactory.d.ag(string, this.mIsHost ? string2 : format), (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) ? null : a2);
        int skinType = TbadkApplication.getInst().getSkinType();
        this.bnF.getLayoutMode().ad(skinType == 1);
        this.bnF.getLayoutMode().k(inflate);
        this.auU.onChangeSkinType(this.bnF.getPageContext(), skinType);
        this.auU.setVisibility(0);
        return inflate;
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aQf;
        TextView aZd;
        HeadImageView bhp;
        TextView bnJ;
        TbClipImageView bnK;
        TextView bnL;
        TextView bnM;

        private a() {
        }

        /* synthetic */ a(j jVar, a aVar) {
            this();
        }
    }

    public void setData(List<GiftList> list) {
        if (list == null) {
            this.bnG = true;
        } else {
            this.bnG = false;
        }
        this.bnE = list;
        notifyDataSetChanged();
    }

    private void applyNightMode(View view) {
        this.bnF.getLayoutMode().ad(TbadkApplication.getInst().getSkinType() == 1);
        this.bnF.getLayoutMode().k(view);
    }
}
