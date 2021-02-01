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
import com.baidu.tbadk.core.util.au;
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
    private NoDataView fIt;
    private List<a.C0741a> jWo;
    private MyGiftListActivity jWp;
    private boolean mIsHost;
    private int jWm = 1;
    private int jWn = 14;
    private boolean jWq = false;
    private View.OnClickListener fhT = new View.OnClickListener() { // from class: com.baidu.tieba.gift.myGiftList.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                b.this.jWp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                return;
            }
            b.this.jWp.showToast(R.string.neterror);
        }
    };

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        this.jWp = myGiftListActivity;
        this.mIsHost = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jWq) {
            return 1;
        }
        if (this.jWo != null && this.jWo.size() != 0) {
            return this.jWo.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Bp */
    public a.C0741a getItem(int i) {
        if (this.jWq) {
            return null;
        }
        int itemId = (int) getItemId(i);
        if (this.jWo == null || this.jWo.size() == 0 || itemId < 0 || itemId >= this.jWo.size()) {
            return null;
        }
        return this.jWo.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.jWm;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.jWq) {
            return bDH();
        }
        if (view == null || view.getTag(R.id.tag_first) == null) {
            view = LayoutInflater.from(this.jWp.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.jWs = (TbImageView) view.findViewById(R.id.item_rank_image);
            aVar2.jWs.setRadius(l.dip2px(this.jWp.getBaseContext(), 25.0f));
            aVar2.jWt = (TextView) view.findViewById(R.id.item_rank_text);
            aVar2.jWu = (HeadImageView) view.findViewById(R.id.item_portrait);
            aVar2.jWu.setRadius(l.dip2px(this.jWp.getBaseContext(), 50.0f));
            aVar2.jWu.setOnClickListener(this.fhT);
            aVar2.jWu.setPlaceHolder(1);
            aVar2.eIO = (TextView) view.findViewById(R.id.user_name);
            aVar2.jWx = (TextView) view.findViewById(R.id.gift_num);
            aVar2.jWw = (TextView) view.findViewById(R.id.gift_value_text);
            aVar2.jWv = (TextView) view.findViewById(R.id.gift_name);
            aVar2.gDo = (TextView) view.findViewById(R.id.time);
            aVar2.bcu = (TextView) view.findViewById(R.id.paly_icon);
            aVar2.jWy = (TextView) view.findViewById(R.id.reward_prefix);
            aVar2.jWz = (TextView) view.findViewById(R.id.reward_num);
            view.setTag(R.id.tag_first, aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag(R.id.tag_first);
        }
        if (!this.mIsHost) {
            aVar.gDo.setVisibility(8);
            aVar.bcu.setVisibility(8);
        } else {
            aVar.bcu.setVisibility(0);
        }
        a.C0741a item = getItem(i);
        if (item != null) {
            if (this.jWp.userType == 1) {
                aVar.jWu.startLoad(item.jVY, 12, false);
                if (item.jWc == 1) {
                    aVar.jWs.setVisibility(0);
                    aVar.jWs.setImageResource(R.drawable.icon_frs_no1);
                    aVar.jWt.setVisibility(8);
                } else if (item.jWc == 2) {
                    aVar.jWs.setVisibility(0);
                    aVar.jWs.setImageResource(R.drawable.icon_frs_no2);
                    aVar.jWt.setVisibility(8);
                } else if (item.jWc == 3) {
                    aVar.jWs.setVisibility(0);
                    aVar.jWs.setImageResource(R.drawable.icon_frs_no3);
                    aVar.jWt.setVisibility(8);
                } else {
                    aVar.jWs.setVisibility(8);
                    aVar.jWt.setVisibility(0);
                    aVar.jWt.setText(item.jWc + "");
                }
            } else {
                aVar.jWu.startLoad(item.thumbnailUrl, 10, false);
                aVar.jWs.setVisibility(8);
                aVar.jWt.setVisibility(8);
            }
            aVar.jWu.setDrawBorder(false);
            aVar.eIO.setText(TextUtils.isEmpty(item.nameShow) ? item.aXE : item.nameShow);
            aVar.jWu.setTag(R.id.tag_first, Long.valueOf(item.aXC));
            aVar.jWu.setTag(R.id.tag_second, item.aXE);
            aVar.jWv.setText(this.jWp.getPageContext().getString(R.string.send_to_you));
            aVar.jWw.setText(this.jWp.getPageContext().getString(R.string.gift_value) + item.jWa);
            if (item.jVZ < 1) {
                aVar.jWx.setVisibility(8);
            } else {
                aVar.jWx.setText(this.jWp.getPageContext().getString(R.string.mutil_sign) + item.jVZ);
                aVar.jWx.setVisibility(0);
            }
            aVar.gDo.setText(au.getFormatTime(item.createTime * 1000));
            aVar.jWy.setVisibility(0);
            aVar.jWz.setVisibility(0);
            if (item.eNW > 0) {
                if (Integer.parseInt(item.jWb) == 1) {
                    aVar.jWz.setText(g.A(item.eNW, 1));
                } else if (Integer.parseInt(item.jWb) == 2) {
                    aVar.jWz.setText(g.A(item.eNW, 2));
                } else {
                    aVar.jWy.setVisibility(8);
                    aVar.jWz.setVisibility(8);
                }
            } else {
                aVar.jWy.setVisibility(8);
                aVar.jWz.setVisibility(8);
            }
        }
        dd(view);
        return view;
    }

    private View bDH() {
        View inflate = LayoutInflater.from(this.jWp.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.jWp.getResources().getString(R.string.send_gift), this.jWp.cNZ()));
        int dimension = (int) this.jWp.getResources().getDimension(R.dimen.tbds200);
        int dimension2 = (int) this.jWp.getResources().getDimension(R.dimen.ds140);
        String cOb = this.jWp.cOb();
        this.jWp.getPageContext().getString(R.string.no_gift);
        String string = this.jWp.getPageContext().getString(R.string.come_on);
        String format = String.format(this.jWp.getPageContext().getString(R.string.send_him_gift_note), cOb);
        Activity pageActivity = this.jWp.getPageContext().getPageActivity();
        NoDataViewFactory.c a3 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA);
        if (!this.mIsHost) {
            string = format;
        }
        this.fIt = NoDataViewFactory.a(pageActivity, inflate, a3, NoDataViewFactory.d.dS(null, string), (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) ? null : a2);
        int skinType = TbadkApplication.getInst().getSkinType();
        this.jWp.getLayoutMode().setNightMode(skinType == 1);
        this.jWp.getLayoutMode().onModeChanged(inflate);
        this.fIt.onChangeSkinType(this.jWp.getPageContext(), skinType);
        this.fIt.setVisibility(0);
        return inflate;
    }

    /* loaded from: classes9.dex */
    private static class a {
        TextView bcu;
        TextView eIO;
        TextView gDo;
        TbImageView jWs;
        TextView jWt;
        HeadImageView jWu;
        TextView jWv;
        TextView jWw;
        TextView jWx;
        TextView jWy;
        TextView jWz;

        private a() {
        }
    }

    public void setData(List<a.C0741a> list) {
        if (list == null || list.size() <= 0) {
            this.jWq = true;
        } else {
            this.jWq = false;
        }
        this.jWo = list;
        notifyDataSetChanged();
    }

    private void dd(View view) {
        this.jWp.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jWp.getLayoutMode().onModeChanged(view);
    }
}
