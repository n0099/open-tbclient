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
    private a fSA;
    private g fSB;
    private ArrayList<g> fSC;
    private RelativeLayout fSg;
    private TextView fSh;
    private BdListView mListView;

    public c(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
    }

    @Override // com.baidu.tieba.ala.b.d
    protected int bIA() {
        return a.h.ala_choose_num_and_date;
    }

    @Override // com.baidu.tieba.ala.b.d
    protected void initView() {
        this.fSg = (RelativeLayout) this.mRootView.findViewById(a.g.choose_bottom_layout);
        this.fSg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bDC();
            }
        });
        this.fSh = (TextView) this.mRootView.findViewById(a.g.choose_bottom_tip);
        this.fSh.setText(a.i.sdk_choose_custom_number_tip);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.b.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < c.this.fSC.size()) {
                    c.this.fSB = (g) c.this.fSC.get(i);
                    if (c.this.fSB != null) {
                        c.this.fSH = c.this.fSB.getNumber();
                        c.this.fSA.tg(c.this.fSH);
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
    public void aF(int i, String str) {
        e((AlaSdkGetGiftListHttpResponseMessage) null);
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        if (alaSdkGetGiftListHttpResponseMessage != null) {
            this.fSC = alaSdkGetGiftListHttpResponseMessage.GZ();
        }
        if (ListUtils.isEmpty(this.fSC)) {
            bIB();
        }
        if (this.fSH > 0) {
            Iterator<g> it = this.fSC.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                g next = it.next();
                if (next != null && this.fSH == next.getNumber()) {
                    this.fSB = next;
                    break;
                }
            }
        }
        this.fSA = new a(this.fSE.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.fSA);
        this.fSA.setGiftNum(this.fSH);
        this.fSA.setData(this.fSC);
    }

    private void bIB() {
        this.fSC = new ArrayList<>();
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
            this.fSC.add(gVar);
        }
    }

    @Override // com.baidu.tieba.ala.b.d
    public void confirm() {
        if (this.fSB != null) {
            g(this.fSB.number, this.fSB.name, false);
        } else {
            this.fSE.finish();
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
            this.fur.getEditView().setText("9999");
            this.fur.getEditView().setSelection(this.fur.getEditView().getText().length());
        }
        this.fur.setSendEnabled(true);
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
        this.fSE.setResult(-1, intent);
        this.fSE.finish();
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
                bVar2.fSo = (RelativeLayout) view.findViewById(a.g.item_root);
                bVar2.fSp = (TextView) view.findViewById(a.g.item_num_title);
                bVar2.fSq = (ImageView) view.findViewById(a.g.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            g item = getItem(i);
            if (item != null) {
                bVar.fSp.setText(item.getNumber() + " " + item.getName());
                if (item.getNumber() == this.mGiftNum) {
                    bVar.fSq.setVisibility(0);
                } else {
                    bVar.fSq.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes7.dex */
    private class b {
        public RelativeLayout fSo;
        public TextView fSp;
        public ImageView fSq;

        private b() {
        }
    }
}
