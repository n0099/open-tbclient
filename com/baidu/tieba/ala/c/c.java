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
import com.baidu.live.data.i;
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
/* loaded from: classes4.dex */
public class c extends d {
    private a fVO;
    private i fVP;
    private ArrayList<i> fVQ;
    private RelativeLayout fVu;
    private TextView fVv;
    private BdListView mListView;

    public c(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
    }

    @Override // com.baidu.tieba.ala.c.d
    protected int bJJ() {
        return a.h.ala_choose_num_and_date;
    }

    @Override // com.baidu.tieba.ala.c.d
    protected void initView() {
        this.fVu = (RelativeLayout) this.mRootView.findViewById(a.g.choose_bottom_layout);
        this.fVu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bEQ();
            }
        });
        this.fVv = (TextView) this.mRootView.findViewById(a.g.choose_bottom_tip);
        this.fVv.setText(a.i.sdk_choose_custom_number_tip);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < c.this.fVQ.size()) {
                    c.this.fVP = (i) c.this.fVQ.get(i);
                    if (c.this.fVP != null) {
                        c.this.fVV = c.this.fVP.getNumber();
                        c.this.fVO.tz(c.this.fVV);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.c.d
    public void f(TextView textView) {
        textView.setText(a.i.sdk_choose_number_title);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        super.e(alaLiveInputEditView);
        alaLiveInputEditView.setHintText(this.mContext.getResources().getString(a.i.sdk_choose_input_num_hint));
    }

    @Override // com.baidu.tieba.ala.c.d
    public void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        e(alaSdkGetGiftListHttpResponseMessage);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void aF(int i, String str) {
        e((AlaSdkGetGiftListHttpResponseMessage) null);
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        if (alaSdkGetGiftListHttpResponseMessage != null) {
            this.fVQ = alaSdkGetGiftListHttpResponseMessage.Hz();
        }
        if (ListUtils.isEmpty(this.fVQ)) {
            bJK();
        }
        if (this.fVV > 0) {
            Iterator<i> it = this.fVQ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                i next = it.next();
                if (next != null && this.fVV == next.getNumber()) {
                    this.fVP = next;
                    break;
                }
            }
        }
        this.fVO = new a(this.fVS.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.fVO);
        this.fVO.setGiftNum(this.fVV);
        this.fVO.setData(this.fVQ);
    }

    private void bJK() {
        this.fVQ = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            i iVar = new i();
            switch (i) {
                case 0:
                    iVar.number = 1;
                    iVar.name = "一心一意";
                    break;
                case 1:
                    iVar.number = 10;
                    iVar.name = "十全十美";
                    break;
                case 2:
                    iVar.number = 66;
                    iVar.name = "六六大顺";
                    break;
                case 3:
                    iVar.number = Opcodes.NEWARRAY;
                    iVar.name = "要抱抱";
                    break;
                case 4:
                    iVar.number = 520;
                    iVar.name = "我爱你";
                    break;
                case 5:
                    iVar.number = ResponseCode.MCASAT_SEND_MSG_COLSE_ROOM;
                    iVar.name = "一生一世";
                    break;
            }
            this.fVQ.add(iVar);
        }
    }

    @Override // com.baidu.tieba.ala.c.d
    public void confirm() {
        if (this.fVP != null) {
            g(this.fVP.number, this.fVP.name, false);
        } else {
            this.fVS.finish();
        }
    }

    @Override // com.baidu.tieba.ala.c.d
    public void tw(int i) {
        super.tw(i);
        g(i, "", true);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        super.a(charSequence, i, i2, i3);
        if (JavaTypesHelper.toInt(charSequence.toString(), 0) > 9999) {
            this.fxG.getEditView().setText("9999");
            this.fxG.getEditView().setSelection(this.fxG.getEditView().getText().length());
        }
        this.fxG.setSendEnabled(true);
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
        this.fVS.setResult(-1, intent);
        this.fVS.finish();
    }

    @Override // com.baidu.tieba.ala.c.d
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        private List<i> dataList;
        private Context mContext;
        private int mGiftNum;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void setGiftNum(int i) {
            this.mGiftNum = i;
        }

        public void tz(int i) {
            if (this.mGiftNum != i) {
                this.mGiftNum = i;
                notifyDataSetChanged();
            }
        }

        public void setData(List<i> list) {
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
        /* renamed from: ea */
        public i getItem(int i) {
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
                bVar2.fVC = (RelativeLayout) view.findViewById(a.g.item_root);
                bVar2.fVD = (TextView) view.findViewById(a.g.item_num_title);
                bVar2.fVE = (ImageView) view.findViewById(a.g.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            i item = getItem(i);
            if (item != null) {
                bVar.fVD.setText(item.getNumber() + " " + item.getName());
                if (item.getNumber() == this.mGiftNum) {
                    bVar.fVE.setVisibility(0);
                } else {
                    bVar.fVE.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        public RelativeLayout fVC;
        public TextView fVD;
        public ImageView fVE;

        private b() {
        }
    }
}
