package com.baidu.tieba.ala.b;

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
import com.baidu.android.imsdk.ResponseCode;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.g;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.view.input.AlaLiveInputEditView;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tieba.ala.AlaChooseGiftActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends d {
    private a fSE;
    private g fSF;
    private ArrayList<g> fSG;
    private RelativeLayout fSk;
    private TextView fSl;
    private BdListView mListView;

    public c(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
    }

    @Override // com.baidu.tieba.ala.b.d
    protected int bIB() {
        return a.h.ala_choose_num_and_date;
    }

    @Override // com.baidu.tieba.ala.b.d
    protected void initView() {
        this.fSk = (RelativeLayout) this.mRootView.findViewById(a.g.choose_bottom_layout);
        this.fSk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bDD();
            }
        });
        this.fSl = (TextView) this.mRootView.findViewById(a.g.choose_bottom_tip);
        this.fSl.setText(a.i.sdk_choose_custom_number_tip);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.b.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < c.this.fSG.size()) {
                    c.this.fSF = (g) c.this.fSG.get(i);
                    if (c.this.fSF != null) {
                        c.this.fSL = c.this.fSF.getNumber();
                        c.this.fSE.tg(c.this.fSL);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.b.d
    public void f(TextView textView) {
        textView.setText(a.i.sdk_choose_number_title);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        super.e(alaLiveInputEditView);
        alaLiveInputEditView.setHintText(this.mContext.getResources().getString(a.i.sdk_choose_input_num_hint));
    }

    @Override // com.baidu.tieba.ala.b.d
    public void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        e(alaSdkGetGiftListHttpResponseMessage);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void aE(int i, String str) {
        e((AlaSdkGetGiftListHttpResponseMessage) null);
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        if (alaSdkGetGiftListHttpResponseMessage != null) {
            this.fSG = alaSdkGetGiftListHttpResponseMessage.GZ();
        }
        if (ListUtils.isEmpty(this.fSG)) {
            bIC();
        }
        if (this.fSL > 0) {
            Iterator<g> it = this.fSG.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                g next = it.next();
                if (next != null && this.fSL == next.getNumber()) {
                    this.fSF = next;
                    break;
                }
            }
        }
        this.fSE = new a(this.fSI.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.fSE);
        this.fSE.setGiftNum(this.fSL);
        this.fSE.setData(this.fSG);
    }

    private void bIC() {
        this.fSG = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            g gVar = new g();
            switch (i) {
                case 0:
                    gVar.number = 1;
                    gVar.name = "一心一意";
                    break;
                case 1:
                    gVar.number = 10;
                    gVar.name = "十全十美";
                    break;
                case 2:
                    gVar.number = 66;
                    gVar.name = "六六大顺";
                    break;
                case 3:
                    gVar.number = Opcodes.NEWARRAY;
                    gVar.name = "要抱抱";
                    break;
                case 4:
                    gVar.number = 520;
                    gVar.name = "我爱你";
                    break;
                case 5:
                    gVar.number = ResponseCode.MCASAT_SEND_MSG_COLSE_ROOM;
                    gVar.name = "一生一世";
                    break;
            }
            this.fSG.add(gVar);
        }
    }

    @Override // com.baidu.tieba.ala.b.d
    public void confirm() {
        if (this.fSF != null) {
            g(this.fSF.number, this.fSF.name, false);
        } else {
            this.fSI.finish();
        }
    }

    @Override // com.baidu.tieba.ala.b.d
    public void td(int i) {
        super.td(i);
        g(i, "", true);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        super.a(charSequence, i, i2, i3);
        if (JavaTypesHelper.toInt(charSequence.toString(), 0) > 9999) {
            this.fuv.getEditView().setText("9999");
            this.fuv.getEditView().setSelection(this.fuv.getEditView().getText().length());
        }
        this.fuv.setSendEnabled(true);
    }

    private void g(int i, String str, boolean z) {
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
        this.fSI.setResult(-1, intent);
        this.fSI.finish();
    }

    @Override // com.baidu.tieba.ala.b.d
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends BaseAdapter {
        private List<g> dataList;
        private Context mContext;
        private int mGiftNum;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void setGiftNum(int i) {
            this.mGiftNum = i;
        }

        public void tg(int i) {
            if (this.mGiftNum != i) {
                this.mGiftNum = i;
                notifyDataSetChanged();
            }
        }

        public void setData(List<g> list) {
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
        /* renamed from: dW */
        public g getItem(int i) {
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
                bVar2.fSs = (RelativeLayout) view.findViewById(a.g.item_root);
                bVar2.fSt = (TextView) view.findViewById(a.g.item_num_title);
                bVar2.fSu = (ImageView) view.findViewById(a.g.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                bVar.fSt.setText(item.getNumber() + " " + item.getName());
                if (item.getNumber() == this.mGiftNum) {
                    bVar.fSu.setVisibility(0);
                } else {
                    bVar.fSu.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes7.dex */
    private class b {
        public RelativeLayout fSs;
        public TextView fSt;
        public ImageView fSu;

        private b() {
        }
    }
}
