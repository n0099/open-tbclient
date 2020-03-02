package com.baidu.tieba.ala.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.e;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.u.a;
import com.baidu.live.view.input.AlaLiveInputEditView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tieba.ala.AlaChooseGiftActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d {
    private a exQ;
    private e exR;
    private ArrayList<e> exS;
    private RelativeLayout exw;
    private TextView exx;
    private BdListView mListView;

    public c(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
    }

    @Override // com.baidu.tieba.ala.a.d
    protected int getLayoutResId() {
        return a.h.ala_choose_num_and_date;
    }

    @Override // com.baidu.tieba.ala.a.d
    protected void initView() {
        this.exw = (RelativeLayout) this.mRootView.findViewById(a.g.choose_bottom_layout);
        this.exw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bby();
            }
        });
        this.exx = (TextView) this.mRootView.findViewById(a.g.choose_bottom_tip);
        this.exx.setText(a.i.sdk_choose_custom_number_tip);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.a.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < c.this.exS.size()) {
                    c.this.exR = (e) c.this.exS.get(i);
                    if (c.this.exR != null) {
                        c.this.exX = c.this.exR.getNumber();
                        c.this.exQ.pg(c.this.exX);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.a.d
    public void d(TextView textView) {
        textView.setText(a.i.sdk_choose_number_title);
    }

    @Override // com.baidu.tieba.ala.a.d
    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        super.e(alaLiveInputEditView);
        alaLiveInputEditView.setHintText(this.mContext.getResources().getString(a.i.sdk_choose_input_num_hint));
    }

    @Override // com.baidu.tieba.ala.a.d
    public void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        d(alaSdkGetGiftListHttpResponseMessage);
    }

    @Override // com.baidu.tieba.ala.a.d
    public void aj(int i, String str) {
        d((AlaSdkGetGiftListHttpResponseMessage) null);
    }

    private void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        if (alaSdkGetGiftListHttpResponseMessage != null) {
            this.exS = alaSdkGetGiftListHttpResponseMessage.uH();
        }
        if (ListUtils.isEmpty(this.exS)) {
            beb();
        }
        if (this.exX > 0) {
            Iterator<e> it = this.exS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e next = it.next();
                if (next != null && this.exX == next.getNumber()) {
                    this.exR = next;
                    break;
                }
            }
        }
        this.exQ = new a(this.exU.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.exQ);
        this.exQ.setGiftNum(this.exX);
        this.exQ.setData(this.exS);
    }

    private void beb() {
        this.exS = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            e eVar = new e();
            switch (i) {
                case 0:
                    eVar.number = 1;
                    eVar.name = "一心一意";
                    break;
                case 1:
                    eVar.number = 10;
                    eVar.name = "十全十美";
                    break;
                case 2:
                    eVar.number = 66;
                    eVar.name = "六六大顺";
                    break;
                case 3:
                    eVar.number = Opcodes.NEWARRAY;
                    eVar.name = "要抱抱";
                    break;
                case 4:
                    eVar.number = UIMsg.m_AppUI.MSG_PLACEFIELD_RELOAD;
                    eVar.name = "我爱你";
                    break;
                case 5:
                    eVar.number = 1314;
                    eVar.name = "一生一世";
                    break;
            }
            this.exS.add(eVar);
        }
    }

    @Override // com.baidu.tieba.ala.a.d
    public void confirm() {
        if (this.exR != null) {
            f(this.exR.number, this.exR.name, false);
        } else {
            this.exU.finish();
        }
    }

    @Override // com.baidu.tieba.ala.a.d
    public void pd(int i) {
        super.pd(i);
        f(i, "", true);
    }

    @Override // com.baidu.tieba.ala.a.d
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        super.a(charSequence, i, i2, i3);
        if (JavaTypesHelper.toInt(charSequence.toString(), 0) > 9999) {
            this.egL.getEditView().setText("9999");
            this.egL.getEditView().setSelection(this.egL.getEditView().getText().length());
        }
        this.egL.setSendEnabled(true);
    }

    private void f(int i, String str, boolean z) {
        Intent intent = new Intent();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("num_custom", z);
            jSONObject.put("num_name", str);
            jSONObject.put("num_number", i);
            intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.exU.setResult(-1, intent);
        this.exU.finish();
    }

    @Override // com.baidu.tieba.ala.a.d
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BaseAdapter {
        private List<e> dataList;
        private Context mContext;
        private int mGiftNum;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void setGiftNum(int i) {
            this.mGiftNum = i;
        }

        public void pg(int i) {
            if (this.mGiftNum != i) {
                this.mGiftNum = i;
                notifyDataSetChanged();
            }
        }

        public void setData(List<e> list) {
            this.dataList = new ArrayList(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.dataList == null) {
                return 0;
            }
            return this.dataList.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: bz */
        public e getItem(int i) {
            if (this.dataList == null) {
                return null;
            }
            return this.dataList.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                b bVar2 = new b();
                view = LayoutInflater.from(this.mContext).inflate(a.h.ala_choose_num_and_date_item, viewGroup, false);
                bVar2.exE = (RelativeLayout) view.findViewById(a.g.item_root);
                bVar2.exF = (TextView) view.findViewById(a.g.item_num_title);
                bVar2.exG = (ImageView) view.findViewById(a.g.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            e item = getItem(i);
            if (item != null) {
                bVar.exF.setText(item.getNumber() + HanziToPinyin.Token.SEPARATOR + item.getName());
                if (item.getNumber() == this.mGiftNum) {
                    bVar.exG.setVisibility(0);
                } else {
                    bVar.exG.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        public RelativeLayout exE;
        public TextView exF;
        public ImageView exG;

        private b() {
        }
    }
}
