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
    private List<a.C0742a> jWC;
    private MyGiftListActivity jWD;
    private boolean mIsHost;
    private int jWA = 1;
    private int jWB = 14;
    private boolean jWE = false;
    private View.OnClickListener fhT = new View.OnClickListener() { // from class: com.baidu.tieba.gift.myGiftList.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                b.this.jWD.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                return;
            }
            b.this.jWD.showToast(R.string.neterror);
        }
    };

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        this.jWD = myGiftListActivity;
        this.mIsHost = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jWE) {
            return 1;
        }
        if (this.jWC != null && this.jWC.size() != 0) {
            return this.jWC.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Bp */
    public a.C0742a getItem(int i) {
        if (this.jWE) {
            return null;
        }
        int itemId = (int) getItemId(i);
        if (this.jWC == null || this.jWC.size() == 0 || itemId < 0 || itemId >= this.jWC.size()) {
            return null;
        }
        return this.jWC.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.jWA;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.jWE) {
            return bDH();
        }
        if (view == null || view.getTag(R.id.tag_first) == null) {
            view = LayoutInflater.from(this.jWD.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.jWG = (TbImageView) view.findViewById(R.id.item_rank_image);
            aVar2.jWG.setRadius(l.dip2px(this.jWD.getBaseContext(), 25.0f));
            aVar2.jWH = (TextView) view.findViewById(R.id.item_rank_text);
            aVar2.jWI = (HeadImageView) view.findViewById(R.id.item_portrait);
            aVar2.jWI.setRadius(l.dip2px(this.jWD.getBaseContext(), 50.0f));
            aVar2.jWI.setOnClickListener(this.fhT);
            aVar2.jWI.setPlaceHolder(1);
            aVar2.eIO = (TextView) view.findViewById(R.id.user_name);
            aVar2.jWL = (TextView) view.findViewById(R.id.gift_num);
            aVar2.jWK = (TextView) view.findViewById(R.id.gift_value_text);
            aVar2.jWJ = (TextView) view.findViewById(R.id.gift_name);
            aVar2.gDC = (TextView) view.findViewById(R.id.time);
            aVar2.bcu = (TextView) view.findViewById(R.id.paly_icon);
            aVar2.jWM = (TextView) view.findViewById(R.id.reward_prefix);
            aVar2.jWN = (TextView) view.findViewById(R.id.reward_num);
            view.setTag(R.id.tag_first, aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag(R.id.tag_first);
        }
        if (!this.mIsHost) {
            aVar.gDC.setVisibility(8);
            aVar.bcu.setVisibility(8);
        } else {
            aVar.bcu.setVisibility(0);
        }
        a.C0742a item = getItem(i);
        if (item != null) {
            if (this.jWD.userType == 1) {
                aVar.jWI.startLoad(item.jWm, 12, false);
                if (item.jWq == 1) {
                    aVar.jWG.setVisibility(0);
                    aVar.jWG.setImageResource(R.drawable.icon_frs_no1);
                    aVar.jWH.setVisibility(8);
                } else if (item.jWq == 2) {
                    aVar.jWG.setVisibility(0);
                    aVar.jWG.setImageResource(R.drawable.icon_frs_no2);
                    aVar.jWH.setVisibility(8);
                } else if (item.jWq == 3) {
                    aVar.jWG.setVisibility(0);
                    aVar.jWG.setImageResource(R.drawable.icon_frs_no3);
                    aVar.jWH.setVisibility(8);
                } else {
                    aVar.jWG.setVisibility(8);
                    aVar.jWH.setVisibility(0);
                    aVar.jWH.setText(item.jWq + "");
                }
            } else {
                aVar.jWI.startLoad(item.thumbnailUrl, 10, false);
                aVar.jWG.setVisibility(8);
                aVar.jWH.setVisibility(8);
            }
            aVar.jWI.setDrawBorder(false);
            aVar.eIO.setText(TextUtils.isEmpty(item.nameShow) ? item.aXE : item.nameShow);
            aVar.jWI.setTag(R.id.tag_first, Long.valueOf(item.aXC));
            aVar.jWI.setTag(R.id.tag_second, item.aXE);
            aVar.jWJ.setText(this.jWD.getPageContext().getString(R.string.send_to_you));
            aVar.jWK.setText(this.jWD.getPageContext().getString(R.string.gift_value) + item.jWo);
            if (item.jWn < 1) {
                aVar.jWL.setVisibility(8);
            } else {
                aVar.jWL.setText(this.jWD.getPageContext().getString(R.string.mutil_sign) + item.jWn);
                aVar.jWL.setVisibility(0);
            }
            aVar.gDC.setText(au.getFormatTime(item.createTime * 1000));
            aVar.jWM.setVisibility(0);
            aVar.jWN.setVisibility(0);
            if (item.eNW > 0) {
                if (Integer.parseInt(item.jWp) == 1) {
                    aVar.jWN.setText(g.A(item.eNW, 1));
                } else if (Integer.parseInt(item.jWp) == 2) {
                    aVar.jWN.setText(g.A(item.eNW, 2));
                } else {
                    aVar.jWM.setVisibility(8);
                    aVar.jWN.setVisibility(8);
                }
            } else {
                aVar.jWM.setVisibility(8);
                aVar.jWN.setVisibility(8);
            }
        }
        dd(view);
        return view;
    }

    private View bDH() {
        View inflate = LayoutInflater.from(this.jWD.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.jWD.getResources().getString(R.string.send_gift), this.jWD.cOg()));
        int dimension = (int) this.jWD.getResources().getDimension(R.dimen.tbds200);
        int dimension2 = (int) this.jWD.getResources().getDimension(R.dimen.ds140);
        String cOi = this.jWD.cOi();
        this.jWD.getPageContext().getString(R.string.no_gift);
        String string = this.jWD.getPageContext().getString(R.string.come_on);
        String format = String.format(this.jWD.getPageContext().getString(R.string.send_him_gift_note), cOi);
        Activity pageActivity = this.jWD.getPageContext().getPageActivity();
        NoDataViewFactory.c a3 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA);
        if (!this.mIsHost) {
            string = format;
        }
        this.fIt = NoDataViewFactory.a(pageActivity, inflate, a3, NoDataViewFactory.d.dS(null, string), (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) ? null : a2);
        int skinType = TbadkApplication.getInst().getSkinType();
        this.jWD.getLayoutMode().setNightMode(skinType == 1);
        this.jWD.getLayoutMode().onModeChanged(inflate);
        this.fIt.onChangeSkinType(this.jWD.getPageContext(), skinType);
        this.fIt.setVisibility(0);
        return inflate;
    }

    /* loaded from: classes9.dex */
    private static class a {
        TextView bcu;
        TextView eIO;
        TextView gDC;
        TbImageView jWG;
        TextView jWH;
        HeadImageView jWI;
        TextView jWJ;
        TextView jWK;
        TextView jWL;
        TextView jWM;
        TextView jWN;

        private a() {
        }
    }

    public void setData(List<a.C0742a> list) {
        if (list == null || list.size() <= 0) {
            this.jWE = true;
        } else {
            this.jWE = false;
        }
        this.jWC = list;
        notifyDataSetChanged();
    }

    private void dd(View view) {
        this.jWD.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jWD.getLayoutMode().onModeChanged(view);
    }
}
