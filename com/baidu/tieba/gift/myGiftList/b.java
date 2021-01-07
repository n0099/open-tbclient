package com.baidu.tieba.gift.myGiftList;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.giftTab.g;
import com.baidu.tieba.gift.myGiftList.a;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    private NoDataView fKO;
    private List<a.C0757a> jTr;
    private MyGiftListActivity jTs;
    private boolean mIsHost;
    private int jTp = 1;
    private int jTq = 14;
    private boolean jTt = false;
    private View.OnClickListener fko = new View.OnClickListener() { // from class: com.baidu.tieba.gift.myGiftList.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                b.this.jTs.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                return;
            }
            b.this.jTs.showToast(R.string.neterror);
        }
    };

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        this.jTs = myGiftListActivity;
        this.mIsHost = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jTt) {
            return 1;
        }
        if (this.jTr != null && this.jTr.size() != 0) {
            return this.jTr.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: CG */
    public a.C0757a getItem(int i) {
        if (this.jTt) {
            return null;
        }
        int itemId = (int) getItemId(i);
        if (this.jTr == null || this.jTr.size() == 0 || itemId < 0 || itemId >= this.jTr.size()) {
            return null;
        }
        return this.jTr.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.jTp;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.jTt) {
            return bHi();
        }
        if (view == null || view.getTag(R.id.tag_first) == null) {
            view = LayoutInflater.from(this.jTs.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.jTv = (TbImageView) view.findViewById(R.id.item_rank_image);
            aVar2.jTv.setRadius(l.dip2px(this.jTs.getBaseContext(), 25.0f));
            aVar2.jTw = (TextView) view.findViewById(R.id.item_rank_text);
            aVar2.jTx = (HeadImageView) view.findViewById(R.id.item_portrait);
            aVar2.jTx.setRadius(l.dip2px(this.jTs.getBaseContext(), 50.0f));
            aVar2.jTx.setOnClickListener(this.fko);
            aVar2.jTx.setPlaceHolder(1);
            aVar2.eLt = (TextView) view.findViewById(R.id.user_name);
            aVar2.jTA = (TextView) view.findViewById(R.id.gift_num);
            aVar2.jTz = (TextView) view.findViewById(R.id.gift_value_text);
            aVar2.jTy = (TextView) view.findViewById(R.id.gift_name);
            aVar2.gFk = (TextView) view.findViewById(R.id.time);
            aVar2.bea = (TextView) view.findViewById(R.id.paly_icon);
            aVar2.jTB = (TextView) view.findViewById(R.id.reward_prefix);
            aVar2.jTC = (TextView) view.findViewById(R.id.reward_num);
            view.setTag(R.id.tag_first, aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag(R.id.tag_first);
        }
        if (!this.mIsHost) {
            aVar.gFk.setVisibility(8);
            aVar.bea.setVisibility(8);
        } else {
            aVar.bea.setVisibility(0);
        }
        a.C0757a item = getItem(i);
        if (item != null) {
            if (this.jTs.userType == 1) {
                aVar.jTx.startLoad(item.jTb, 12, false);
                if (item.jTf == 1) {
                    aVar.jTv.setVisibility(0);
                    aVar.jTv.setImageResource(R.drawable.icon_frs_no1);
                    aVar.jTw.setVisibility(8);
                } else if (item.jTf == 2) {
                    aVar.jTv.setVisibility(0);
                    aVar.jTv.setImageResource(R.drawable.icon_frs_no2);
                    aVar.jTw.setVisibility(8);
                } else if (item.jTf == 3) {
                    aVar.jTv.setVisibility(0);
                    aVar.jTv.setImageResource(R.drawable.icon_frs_no3);
                    aVar.jTw.setVisibility(8);
                } else {
                    aVar.jTv.setVisibility(8);
                    aVar.jTw.setVisibility(0);
                    aVar.jTw.setText(item.jTf + "");
                }
            } else {
                aVar.jTx.startLoad(item.thumbnailUrl, 10, false);
                aVar.jTv.setVisibility(8);
                aVar.jTw.setVisibility(8);
            }
            aVar.jTx.setDrawBorder(false);
            aVar.eLt.setText(TextUtils.isEmpty(item.nameShow) ? item.aZm : item.nameShow);
            aVar.jTx.setTag(R.id.tag_first, Long.valueOf(item.aZk));
            aVar.jTx.setTag(R.id.tag_second, item.aZm);
            aVar.jTy.setText(this.jTs.getPageContext().getString(R.string.send_to_you));
            aVar.jTz.setText(this.jTs.getPageContext().getString(R.string.gift_value) + item.jTd);
            if (item.jTc < 1) {
                aVar.jTA.setVisibility(8);
            } else {
                aVar.jTA.setText(this.jTs.getPageContext().getString(R.string.mutil_sign) + item.jTc);
                aVar.jTA.setVisibility(0);
            }
            aVar.gFk.setText(at.getFormatTime(item.createTime * 1000));
            aVar.jTB.setVisibility(0);
            aVar.jTC.setVisibility(0);
            if (item.eQv > 0) {
                if (Integer.parseInt(item.jTe) == 1) {
                    aVar.jTC.setText(g.C(item.eQv, 1));
                } else if (Integer.parseInt(item.jTe) == 2) {
                    aVar.jTC.setText(g.C(item.eQv, 2));
                } else {
                    aVar.jTB.setVisibility(8);
                    aVar.jTC.setVisibility(8);
                }
            } else {
                aVar.jTB.setVisibility(8);
                aVar.jTC.setVisibility(8);
            }
        }
        df(view);
        return view;
    }

    private View bHi() {
        View inflate = LayoutInflater.from(this.jTs.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.jTs.getResources().getString(R.string.send_gift), this.jTs.cPU()));
        int dimension = (int) this.jTs.getResources().getDimension(R.dimen.tbds200);
        int dimension2 = (int) this.jTs.getResources().getDimension(R.dimen.ds140);
        String cPW = this.jTs.cPW();
        this.jTs.getPageContext().getString(R.string.no_gift);
        String string = this.jTs.getPageContext().getString(R.string.come_on);
        String format = String.format(this.jTs.getPageContext().getString(R.string.send_him_gift_note), cPW);
        Activity pageActivity = this.jTs.getPageContext().getPageActivity();
        NoDataViewFactory.c a3 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA);
        if (!this.mIsHost) {
            string = format;
        }
        this.fKO = NoDataViewFactory.a(pageActivity, inflate, a3, NoDataViewFactory.d.dY(null, string), (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) ? null : a2);
        int skinType = TbadkApplication.getInst().getSkinType();
        this.jTs.getLayoutMode().setNightMode(skinType == 1);
        this.jTs.getLayoutMode().onModeChanged(inflate);
        this.fKO.onChangeSkinType(this.jTs.getPageContext(), skinType);
        this.fKO.setVisibility(0);
        return inflate;
    }

    /* loaded from: classes9.dex */
    private static class a {
        TextView bea;
        TextView eLt;
        TextView gFk;
        TextView jTA;
        TextView jTB;
        TextView jTC;
        TbImageView jTv;
        TextView jTw;
        HeadImageView jTx;
        TextView jTy;
        TextView jTz;

        private a() {
        }
    }

    public void setData(List<a.C0757a> list) {
        if (list == null || list.size() <= 0) {
            this.jTt = true;
        } else {
            this.jTt = false;
        }
        this.jTr = list;
        notifyDataSetChanged();
    }

    private void df(View view) {
        this.jTs.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jTs.getLayoutMode().onModeChanged(view);
    }
}
