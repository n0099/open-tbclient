package com.baidu.tieba.consumptionRecords;

import android.content.ClipboardManager;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.d;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class c extends BaseAdapter {
    private TbPageContext<?> eUY;
    private ArrayList<com.baidu.tieba.consumptionRecords.a> orderList;
    private int type;

    /* loaded from: classes9.dex */
    public static class a {
        public TextView eHx;
        public TextView iDd;
        public TbImageView iDe;
        public TextView iDf;
        public TextView iDg;
        public TextView iDh;
        public TextView iDi;
        public View iDj;
        public TextView iDk;
        public TextView iDl;
    }

    public c(TbPageContext<?> tbPageContext, int i) {
        this.eUY = tbPageContext;
        this.type = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.orderList == null) {
            return 0;
        }
        return this.orderList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xg */
    public com.baidu.tieba.consumptionRecords.a getItem(int i) {
        if (this.orderList == null || this.orderList.size() <= 0 || i < 0 || i >= getCount()) {
            return null;
        }
        return this.orderList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        com.baidu.tieba.consumptionRecords.a item = getItem(i);
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.records_item_layout, viewGroup, false);
            a aVar2 = new a();
            aVar2.iDd = (TextView) view.findViewById(R.id.order_id_textview);
            aVar2.iDe = (TbImageView) view.findViewById(R.id.order_status_textview);
            aVar2.eHx = (TextView) view.findViewById(R.id.order_title_textview);
            aVar2.iDf = (TextView) view.findViewById(R.id.order_price_textview);
            aVar2.iDi = (TextView) view.findViewById(R.id.order_id_tip);
            aVar2.iDh = (TextView) view.findViewById(R.id.order_account_textview);
            aVar2.iDg = (TextView) view.findViewById(R.id.order_time_textview);
            aVar2.iDj = view.findViewById(R.id.order_activity_content);
            aVar2.iDk = (TextView) view.findViewById(R.id.activity_desc_textview);
            aVar2.iDl = (TextView) view.findViewById(R.id.activity_button_textview);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        a(aVar, item);
        this.eUY.getLayoutMode().onModeChanged(view);
        return view;
    }

    private void a(a aVar, final com.baidu.tieba.consumptionRecords.a aVar2) {
        SpannableString spannableString;
        SpannableString spannableString2;
        SpannableString spannableString3;
        SpannableString spannableString4;
        if (aVar != null && aVar2 != null) {
            aVar.iDi.setText(this.eUY.getString(R.string.order_id) + "    ");
            aVar.iDd.setText(aVar2.getOrderId());
            aVar.iDd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.consumptionRecords.c.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    String orderId = aVar2.getOrderId();
                    if (!StringUtils.isNull(orderId)) {
                        ClipboardManager clipboardManager = (ClipboardManager) c.this.eUY.getPageActivity().getSystemService("clipboard");
                        clipboardManager.setText(orderId);
                        if (clipboardManager.getText() != null) {
                            l.showToast(c.this.eUY.getPageActivity(), R.string.copy_to_clip);
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
            });
            if (aVar2.getStatus() == 1) {
                aVar.iDe.startLoad(String.valueOf(R.drawable.icon_payment_success), 24, false);
                ap.setViewTextColor(aVar.iDe, R.color.CAM_X0305, 1);
            } else {
                aVar.iDe.startLoad(String.valueOf(R.drawable.icon_payment_fail), 24, false);
                ap.setViewTextColor(aVar.iDe, R.color.CAM_X0109, 1);
            }
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0109));
            ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0105));
            new ForegroundColorSpan(ap.getColor(R.color.CAM_X0305));
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(24, true);
            if (this.type == 1) {
                SpannableString a2 = a(R.string.buy_product, aVar2.getTitle(), foregroundColorSpan, foregroundColorSpan2);
                SpannableString a3 = a(R.string.consumption_t_bean, aVar2.ctw(), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan);
                spannableString2 = a(R.string.buy_time, aVar2.getCreateTime(), foregroundColorSpan, foregroundColorSpan2);
                spannableString = null;
                spannableString3 = a3;
                spannableString4 = a2;
            } else if (this.type == 2) {
                SpannableString a4 = a(R.string.get_with_product, aVar2.getTitle(), foregroundColorSpan, foregroundColorSpan2);
                SpannableString a5 = a(R.string.get_t_bean, aVar2.ctw(), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan);
                SpannableString a6 = a(R.string.buy_time, aVar2.getCreateTime(), foregroundColorSpan, foregroundColorSpan2);
                String str = "" + aVar2.ctB();
                String str2 = this.eUY.getString(R.string.alternative_account) + "    " + str;
                spannableString = new SpannableString(str2);
                UtilHelper.setSpan(spannableString, str2, str2, foregroundColorSpan);
                UtilHelper.setSpan(spannableString, str2, str, foregroundColorSpan2);
                spannableString2 = a6;
                spannableString3 = a5;
                spannableString4 = a4;
            } else if (this.type == 3) {
                String string = this.eUY.getString(R.string.recharge_product);
                String title = aVar2.getTitle();
                String str3 = string + "    " + title;
                SpannableString spannableString5 = new SpannableString(str3);
                UtilHelper.setSpan(spannableString5, str3, str3, foregroundColorSpan);
                UtilHelper.setSpan(spannableString5, str3, title, foregroundColorSpan2);
                String str4 = ("" + aVar2.cty()) + this.eUY.getString(R.string.recharge_use_money);
                String str5 = this.eUY.getString(R.string.recharge_money) + "    " + str4;
                SpannableString spannableString6 = new SpannableString(str5);
                UtilHelper.setSpan(spannableString6, str5, str5, foregroundColorSpan);
                UtilHelper.setSpan(spannableString6, str5, str4, foregroundColorSpan2);
                UtilHelper.setSpan(spannableString6, str5, str4, absoluteSizeSpan);
                SpannableString a7 = a(R.string.recharge_time, aVar2.ctx(), foregroundColorSpan, foregroundColorSpan2);
                String str6 = "" + aVar2.ctB();
                String str7 = this.eUY.getString(R.string.recharge_account) + "    " + str6;
                spannableString = new SpannableString(str7);
                UtilHelper.setSpan(spannableString, str7, str7, foregroundColorSpan);
                UtilHelper.setSpan(spannableString, str7, str6, foregroundColorSpan2);
                spannableString2 = a7;
                spannableString3 = spannableString6;
                spannableString4 = spannableString5;
            } else {
                spannableString = null;
                spannableString2 = null;
                spannableString3 = null;
                spannableString4 = null;
            }
            aVar.eHx.setText(spannableString4);
            aVar.iDf.setText(spannableString3);
            aVar.iDg.setText(spannableString2);
            if (!StringUtils.isNull(aVar2.ctB()) && (this.type == 3 || this.type == 2)) {
                aVar.iDh.setVisibility(0);
                aVar.iDh.setText(spannableString);
            } else {
                aVar.iDh.setVisibility(8);
            }
            if (!StringUtils.isNull(aVar2.ctz())) {
                aVar.iDk.setText(aVar2.ctz());
                if (!StringUtils.isNull(aVar2.ctA())) {
                    aVar.iDl.setText(aVar2.ctA());
                    aVar.iDl.setVisibility(0);
                } else {
                    aVar.iDl.setVisibility(8);
                }
                aVar.iDl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.consumptionRecords.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bf.bsV().b(c.this.eUY, new String[]{aVar2.getActivityUrl()});
                    }
                });
                aVar.iDj.setVisibility(0);
                return;
            }
            aVar.iDj.setVisibility(8);
        }
    }

    private SpannableString a(int i, long j, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2) {
        String string = this.eUY.getString(i);
        String long2String = au.long2String(j, "yyyy-MM-dd HH:mm");
        String str = string + "    " + long2String;
        SpannableString spannableString = new SpannableString(str);
        UtilHelper.setSpan(spannableString, str, str, foregroundColorSpan);
        UtilHelper.setSpan(spannableString, str, long2String, foregroundColorSpan2);
        return spannableString;
    }

    private SpannableString a(int i, String str, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2) {
        String str2 = this.eUY.getString(i) + "    " + str;
        SpannableString spannableString = new SpannableString(str2);
        UtilHelper.setSpan(spannableString, str2, str2, foregroundColorSpan);
        UtilHelper.setSpan(spannableString, str2, str, foregroundColorSpan2);
        return spannableString;
    }

    private SpannableString a(int i, long j, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2, AbsoluteSizeSpan absoluteSizeSpan) {
        String string = this.eUY.getString(i);
        String formatOverBaiwanNum = au.formatOverBaiwanNum(j);
        String str = string + "    [icon]" + formatOverBaiwanNum;
        SpannableString spannableString = new SpannableString(str);
        UtilHelper.setSpan(spannableString, str, str, foregroundColorSpan);
        Drawable drawable = ap.getDrawable(R.drawable.icon_huobi_tdou);
        int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds24);
        drawable.setBounds(0, 0, dimens, dimens);
        d dVar = new d(drawable);
        dVar.setPaddingLeft(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
        dVar.setPaddingRight(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
        UtilHelper.setSpan(spannableString, str, "[icon]", dVar);
        UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, foregroundColorSpan2);
        UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, absoluteSizeSpan);
        return spannableString;
    }

    public void al(ArrayList<com.baidu.tieba.consumptionRecords.a> arrayList) {
        this.orderList = arrayList;
    }
}
