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
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    private NoDataView fJS;
    private List<a.C0748a> jYE;
    private MyGiftListActivity jYF;
    private boolean mIsHost;
    private int jYC = 1;
    private int jYD = 14;
    private boolean jYG = false;
    private View.OnClickListener fjv = new View.OnClickListener() { // from class: com.baidu.tieba.gift.myGiftList.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                b.this.jYF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                return;
            }
            b.this.jYF.showToast(R.string.neterror);
        }
    };

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        this.jYF = myGiftListActivity;
        this.mIsHost = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jYG) {
            return 1;
        }
        if (this.jYE != null && this.jYE.size() != 0) {
            return this.jYE.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Bs */
    public a.C0748a getItem(int i) {
        if (this.jYG) {
            return null;
        }
        int itemId = (int) getItemId(i);
        if (this.jYE == null || this.jYE.size() == 0 || itemId < 0 || itemId >= this.jYE.size()) {
            return null;
        }
        return this.jYE.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.jYC;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.jYG) {
            return bDK();
        }
        if (view == null || view.getTag(R.id.tag_first) == null) {
            view = LayoutInflater.from(this.jYF.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.jYI = (TbImageView) view.findViewById(R.id.item_rank_image);
            aVar2.jYI.setRadius(l.dip2px(this.jYF.getBaseContext(), 25.0f));
            aVar2.jYJ = (TextView) view.findViewById(R.id.item_rank_text);
            aVar2.jYK = (HeadImageView) view.findViewById(R.id.item_portrait);
            aVar2.jYK.setRadius(l.dip2px(this.jYF.getBaseContext(), 50.0f));
            aVar2.jYK.setOnClickListener(this.fjv);
            aVar2.jYK.setPlaceHolder(1);
            aVar2.eKp = (TextView) view.findViewById(R.id.user_name);
            aVar2.jYN = (TextView) view.findViewById(R.id.gift_num);
            aVar2.jYM = (TextView) view.findViewById(R.id.gift_value_text);
            aVar2.jYL = (TextView) view.findViewById(R.id.gift_name);
            aVar2.gFl = (TextView) view.findViewById(R.id.time);
            aVar2.bdU = (TextView) view.findViewById(R.id.paly_icon);
            aVar2.jYO = (TextView) view.findViewById(R.id.reward_prefix);
            aVar2.jYP = (TextView) view.findViewById(R.id.reward_num);
            view.setTag(R.id.tag_first, aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag(R.id.tag_first);
        }
        if (!this.mIsHost) {
            aVar.gFl.setVisibility(8);
            aVar.bdU.setVisibility(8);
        } else {
            aVar.bdU.setVisibility(0);
        }
        a.C0748a item = getItem(i);
        if (item != null) {
            if (this.jYF.userType == 1) {
                aVar.jYK.startLoad(item.jYo, 12, false);
                if (item.jYs == 1) {
                    aVar.jYI.setVisibility(0);
                    aVar.jYI.setImageResource(R.drawable.icon_frs_no1);
                    aVar.jYJ.setVisibility(8);
                } else if (item.jYs == 2) {
                    aVar.jYI.setVisibility(0);
                    aVar.jYI.setImageResource(R.drawable.icon_frs_no2);
                    aVar.jYJ.setVisibility(8);
                } else if (item.jYs == 3) {
                    aVar.jYI.setVisibility(0);
                    aVar.jYI.setImageResource(R.drawable.icon_frs_no3);
                    aVar.jYJ.setVisibility(8);
                } else {
                    aVar.jYI.setVisibility(8);
                    aVar.jYJ.setVisibility(0);
                    aVar.jYJ.setText(item.jYs + "");
                }
            } else {
                aVar.jYK.startLoad(item.thumbnailUrl, 10, false);
                aVar.jYI.setVisibility(8);
                aVar.jYJ.setVisibility(8);
            }
            aVar.jYK.setDrawBorder(false);
            aVar.eKp.setText(TextUtils.isEmpty(item.nameShow) ? item.aZe : item.nameShow);
            aVar.jYK.setTag(R.id.tag_first, Long.valueOf(item.aZc));
            aVar.jYK.setTag(R.id.tag_second, item.aZe);
            aVar.jYL.setText(this.jYF.getPageContext().getString(R.string.send_to_you));
            aVar.jYM.setText(this.jYF.getPageContext().getString(R.string.gift_value) + item.jYq);
            if (item.jYp < 1) {
                aVar.jYN.setVisibility(8);
            } else {
                aVar.jYN.setText(this.jYF.getPageContext().getString(R.string.mutil_sign) + item.jYp);
                aVar.jYN.setVisibility(0);
            }
            aVar.gFl.setText(au.getFormatTime(item.createTime * 1000));
            aVar.jYO.setVisibility(0);
            aVar.jYP.setVisibility(0);
            if (item.ePx > 0) {
                if (Integer.parseInt(item.jYr) == 1) {
                    aVar.jYP.setText(g.A(item.ePx, 1));
                } else if (Integer.parseInt(item.jYr) == 2) {
                    aVar.jYP.setText(g.A(item.ePx, 2));
                } else {
                    aVar.jYO.setVisibility(8);
                    aVar.jYP.setVisibility(8);
                }
            } else {
                aVar.jYO.setVisibility(8);
                aVar.jYP.setVisibility(8);
            }
        }
        dd(view);
        return view;
    }

    private View bDK() {
        View inflate = LayoutInflater.from(this.jYF.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.jYF.getResources().getString(R.string.send_gift), this.jYF.cOn()));
        int dimension = (int) this.jYF.getResources().getDimension(R.dimen.tbds200);
        int dimension2 = (int) this.jYF.getResources().getDimension(R.dimen.ds140);
        String cOp = this.jYF.cOp();
        this.jYF.getPageContext().getString(R.string.no_gift);
        String string = this.jYF.getPageContext().getString(R.string.come_on);
        String format = String.format(this.jYF.getPageContext().getString(R.string.send_him_gift_note), cOp);
        Activity pageActivity = this.jYF.getPageContext().getPageActivity();
        NoDataViewFactory.c a3 = NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA);
        if (!this.mIsHost) {
            string = format;
        }
        this.fJS = NoDataViewFactory.a(pageActivity, inflate, a3, NoDataViewFactory.d.dS(null, string), (this.mIsHost || !TbadkApplication.getInst().isGiftSwitchOn()) ? null : a2);
        int skinType = TbadkApplication.getInst().getSkinType();
        this.jYF.getLayoutMode().setNightMode(skinType == 1);
        this.jYF.getLayoutMode().onModeChanged(inflate);
        this.fJS.onChangeSkinType(this.jYF.getPageContext(), skinType);
        this.fJS.setVisibility(0);
        return inflate;
    }

    /* loaded from: classes8.dex */
    private static class a {
        TextView bdU;
        TextView eKp;
        TextView gFl;
        TbImageView jYI;
        TextView jYJ;
        HeadImageView jYK;
        TextView jYL;
        TextView jYM;
        TextView jYN;
        TextView jYO;
        TextView jYP;

        private a() {
        }
    }

    public void setData(List<a.C0748a> list) {
        if (list == null || list.size() <= 0) {
            this.jYG = true;
        } else {
            this.jYG = false;
        }
        this.jYE = list;
        notifyDataSetChanged();
    }

    private void dd(View view) {
        this.jYF.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jYF.getLayoutMode().onModeChanged(view);
    }
}
