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
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    private NoDataView fGh;
    private List<a.C0740a> jOM;
    private MyGiftListActivity jON;
    private boolean mIsHost;
    private int jOK = 1;
    private int jOL = 14;
    private boolean jOO = false;
    private View.OnClickListener ffD = new View.OnClickListener() { // from class: com.baidu.tieba.gift.myGiftList.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                b.this.jON.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                return;
            }
            b.this.jON.showToast(R.string.neterror);
        }
    };

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        this.jON = myGiftListActivity;
        this.mIsHost = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jOO) {
            return 1;
        }
        if (this.jOM != null && this.jOM.size() != 0) {
            return this.jOM.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ba */
    public a.C0740a getItem(int i) {
        if (this.jOO) {
            return null;
        }
        int itemId = (int) getItemId(i);
        if (this.jOM == null || this.jOM.size() == 0 || itemId < 0 || itemId >= this.jOM.size()) {
            return null;
        }
        return this.jOM.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.jOK;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.jOO) {
            return bDp();
        }
        if (view == null || view.getTag(R.id.tag_first) == null) {
            view = LayoutInflater.from(this.jON.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.jOQ = (TbImageView) view.findViewById(R.id.item_rank_image);
            aVar2.jOQ.setRadius(l.dip2px(this.jON.getBaseContext(), 25.0f));
            aVar2.jOR = (TextView) view.findViewById(R.id.item_rank_text);
            aVar2.jOS = (HeadImageView) view.findViewById(R.id.item_portrait);
            aVar2.jOS.setRadius(l.dip2px(this.jON.getBaseContext(), 50.0f));
            aVar2.jOS.setOnClickListener(this.ffD);
            aVar2.jOS.setPlaceHolder(1);
            aVar2.eGI = (TextView) view.findViewById(R.id.user_name);
            aVar2.jOV = (TextView) view.findViewById(R.id.gift_num);
            aVar2.jOU = (TextView) view.findViewById(R.id.gift_value_text);
            aVar2.jOT = (TextView) view.findViewById(R.id.gift_name);
            aVar2.gAE = (TextView) view.findViewById(R.id.time);
            aVar2.aZm = (TextView) view.findViewById(R.id.paly_icon);
            aVar2.jOW = (TextView) view.findViewById(R.id.reward_prefix);
            aVar2.jOX = (TextView) view.findViewById(R.id.reward_num);
            view.setTag(R.id.tag_first, aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag(R.id.tag_first);
        }
        if (!this.mIsHost) {
            aVar.gAE.setVisibility(8);
            aVar.aZm.setVisibility(8);
        } else {
            aVar.aZm.setVisibility(0);
        }
        a.C0740a item = getItem(i);
        if (item != null) {
            if (this.jON.userType == 1) {
                aVar.jOS.startLoad(item.jOw, 12, false);
                if (item.jOA == 1) {
                    aVar.jOQ.setVisibility(0);
                    aVar.jOQ.setImageResource(R.drawable.icon_frs_no1);
                    aVar.jOR.setVisibility(8);
                } else if (item.jOA == 2) {
                    aVar.jOQ.setVisibility(0);
                    aVar.jOQ.setImageResource(R.drawable.icon_frs_no2);
                    aVar.jOR.setVisibility(8);
                } else if (item.jOA == 3) {
                    aVar.jOQ.setVisibility(0);
                    aVar.jOQ.setImageResource(R.drawable.icon_frs_no3);
                    aVar.jOR.setVisibility(8);
                } else {
                    aVar.jOQ.setVisibility(8);
                    aVar.jOR.setVisibility(0);
                    aVar.jOR.setText(item.jOA + "");
                }
            } else {
                aVar.jOS.startLoad(item.thumbnailUrl, 10, false);
                aVar.jOQ.setVisibility(8);
                aVar.jOR.setVisibility(8);
            }
            aVar.jOS.setDrawBorder(false);
            aVar.eGI.setText(TextUtils.isEmpty(item.nameShow) ? item.aUz : item.nameShow);
            aVar.jOS.setTag(R.id.tag_first, Long.valueOf(item.aUx));
            aVar.jOS.setTag(R.id.tag_second, item.aUz);
            aVar.jOT.setText(this.jON.getPageContext().getString(R.string.send_to_you));
            aVar.jOU.setText(this.jON.getPageContext().getString(R.string.gift_value) + item.jOy);
            if (item.jOx < 1) {
                aVar.jOV.setVisibility(8);
            } else {
                aVar.jOV.setText(this.jON.getPageContext().getString(R.string.mutil_sign) + item.jOx);
                aVar.jOV.setVisibility(0);
            }
            aVar.gAE.setText(at.getFormatTime(item.createTime * 1000));
            aVar.jOW.setVisibility(0);
            aVar.jOX.setVisibility(0);
            if (item.eLK > 0) {
                if (Integer.parseInt(item.jOz) == 1) {
                    aVar.jOX.setText(g.C(item.eLK, 1));
                } else if (Integer.parseInt(item.jOz) == 2) {
                    aVar.jOX.setText(g.C(item.eLK, 2));
                } else {
                    aVar.jOW.setVisibility(8);
                    aVar.jOX.setVisibility(8);
                }
            } else {
                aVar.jOW.setVisibility(8);
                aVar.jOX.setVisibility(8);
            }
        }
        df(view);
        return view;
    }

    private View bDp() {
        View inflate = LayoutInflater.from(this.jON.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.jON.getResources().getString(R.string.send_gift), this.jON.cMc()));
        int dimension = (int) this.jON.getResources().getDimension(R.dimen.tbds200);
        int dimension2 = (int) this.jON.getResources().getDimension(R.dimen.ds140);
        String cMe = this.jON.cMe();
        this.jON.getPageContext().getString(R.string.no_gift);
        String string = this.jON.getPageContext().getString(R.string.come_on);
        String format = String.format(this.jON.getPageContext().getString(R.string.send_him_gift_note), cMe);
        Activity pageActivity = this.jON.getPageContext().getPageActivity();
        NoDataViewFactory.c a3 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA);
        if (!this.mIsHost) {
            string = format;
        }
        this.fGh = NoDataViewFactory.a(pageActivity, inflate, a3, NoDataViewFactory.d.dX(null, string), (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) ? null : a2);
        int skinType = TbadkApplication.getInst().getSkinType();
        this.jON.getLayoutMode().setNightMode(skinType == 1);
        this.jON.getLayoutMode().onModeChanged(inflate);
        this.fGh.onChangeSkinType(this.jON.getPageContext(), skinType);
        this.fGh.setVisibility(0);
        return inflate;
    }

    /* loaded from: classes8.dex */
    private static class a {
        TextView aZm;
        TextView eGI;
        TextView gAE;
        TbImageView jOQ;
        TextView jOR;
        HeadImageView jOS;
        TextView jOT;
        TextView jOU;
        TextView jOV;
        TextView jOW;
        TextView jOX;

        private a() {
        }
    }

    public void setData(List<a.C0740a> list) {
        if (list == null || list.size() <= 0) {
            this.jOO = true;
        } else {
            this.jOO = false;
        }
        this.jOM = list;
        notifyDataSetChanged();
    }

    private void df(View view) {
        this.jON.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jON.getLayoutMode().onModeChanged(view);
    }
}
