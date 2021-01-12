package com.baidu.tieba.ala.c;

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
import com.baidu.live.data.k;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.view.input.AlaLiveInputEditView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tieba.ala.AlaChooseGiftActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends d {
    private a gNB;
    private k gNC;
    private ArrayList<k> gND;
    private RelativeLayout gNh;
    private TextView gNi;
    private BdListView mListView;

    public c(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
    }

    @Override // com.baidu.tieba.ala.c.d
    protected int bTm() {
        return a.g.ala_choose_num_and_date;
    }

    @Override // com.baidu.tieba.ala.c.d
    protected void initView() {
        this.gNh = (RelativeLayout) this.mRootView.findViewById(a.f.choose_bottom_layout);
        this.gNh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bNE();
            }
        });
        this.gNi = (TextView) this.mRootView.findViewById(a.f.choose_bottom_tip);
        this.gNi.setText(a.h.sdk_choose_custom_number_tip);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < c.this.gND.size()) {
                    c.this.gNC = (k) c.this.gND.get(i);
                    if (c.this.gNC != null) {
                        c.this.gNH = c.this.gNC.getNumber();
                        c.this.gNB.uk(c.this.gNH);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.c.d
    public void l(TextView textView) {
        textView.setText(a.h.sdk_choose_number_title);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        super.e(alaLiveInputEditView);
        alaLiveInputEditView.setHintText(this.mContext.getResources().getString(a.h.sdk_choose_input_num_hint));
    }

    @Override // com.baidu.tieba.ala.c.d
    public void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        e(alaSdkGetGiftListHttpResponseMessage);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void aW(int i, String str) {
        e((AlaSdkGetGiftListHttpResponseMessage) null);
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        if (alaSdkGetGiftListHttpResponseMessage != null) {
            this.gND = alaSdkGetGiftListHttpResponseMessage.Gn();
        }
        if (ListUtils.isEmpty(this.gND)) {
            bTn();
        }
        if (this.gNH > 0) {
            Iterator<k> it = this.gND.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                k next = it.next();
                if (next != null && this.gNH == next.getNumber()) {
                    this.gNC = next;
                    break;
                }
            }
        }
        this.gNB = new a(this.gNF.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.gNB);
        this.gNB.setGiftNum(this.gNH);
        this.gNB.setData(this.gND);
    }

    private void bTn() {
        this.gND = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            k kVar = new k();
            switch (i) {
                case 0:
                    kVar.number = 1;
                    kVar.name = "一心一意";
                    break;
                case 1:
                    kVar.number = 10;
                    kVar.name = "十全十美";
                    break;
                case 2:
                    kVar.number = 66;
                    kVar.name = "六六大顺";
                    break;
                case 3:
                    kVar.number = Opcodes.NEWARRAY;
                    kVar.name = "要抱抱";
                    break;
                case 4:
                    kVar.number = UIMsg.m_AppUI.MSG_PLACEFIELD_RELOAD;
                    kVar.name = "我爱你";
                    break;
                case 5:
                    kVar.number = ResponseCode.MCASAT_SEND_MSG_COLSE_ROOM;
                    kVar.name = "一生一世";
                    break;
            }
            this.gND.add(kVar);
        }
    }

    @Override // com.baidu.tieba.ala.c.d
    public void confirm() {
        if (this.gNC != null) {
            i(this.gNC.number, this.gNC.name, false);
        } else {
            this.gNF.finish();
        }
    }

    @Override // com.baidu.tieba.ala.c.d
    public void uh(int i) {
        super.uh(i);
        i(i, "", true);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        super.a(charSequence, i, i2, i3);
        if (JavaTypesHelper.toInt(charSequence.toString(), 0) > 9999) {
            this.glq.getEditView().setText("9999");
            this.glq.getEditView().setSelection(this.glq.getEditView().getText().length());
        }
        this.glq.setSendEnabled(true);
    }

    private void i(int i, String str, boolean z) {
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
        this.gNF.setResult(-1, intent);
        this.gNF.finish();
    }

    @Override // com.baidu.tieba.ala.c.d
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends BaseAdapter {
        private List<k> dataList;
        private Context mContext;
        private int mGiftNum;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void setGiftNum(int i) {
            this.mGiftNum = i;
        }

        public void uk(int i) {
            if (this.mGiftNum != i) {
                this.mGiftNum = i;
                notifyDataSetChanged();
            }
        }

        public void setData(List<k> list) {
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
        /* renamed from: cO */
        public k getItem(int i) {
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
                view = LayoutInflater.from(this.mContext).inflate(a.g.ala_choose_num_and_date_item, viewGroup, false);
                bVar2.gNp = (RelativeLayout) view.findViewById(a.f.item_root);
                bVar2.gNq = (TextView) view.findViewById(a.f.item_num_title);
                bVar2.gNr = (ImageView) view.findViewById(a.f.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            k item = getItem(i);
            if (item != null) {
                bVar.gNq.setText(item.getNumber() + " " + item.getName());
                if (item.getNumber() == this.mGiftNum) {
                    bVar.gNr.setVisibility(0);
                } else {
                    bVar.gNr.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes10.dex */
    private class b {
        public RelativeLayout gNp;
        public TextView gNq;
        public ImageView gNr;

        private b() {
        }
    }
}
