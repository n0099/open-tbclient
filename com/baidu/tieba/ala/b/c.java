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
    private RelativeLayout fcG;
    private TextView fcH;
    private a fda;
    private e fdb;
    private ArrayList<e> fdc;
    private BdListView mListView;

    public c(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
    }

    @Override // com.baidu.tieba.ala.b.d
    protected int bnu() {
        return a.h.ala_choose_num_and_date;
    }

    @Override // com.baidu.tieba.ala.b.d
    protected void initView() {
        this.fcG = (RelativeLayout) this.mRootView.findViewById(a.g.choose_bottom_layout);
        this.fcG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bjE();
            }
        });
        this.fcH = (TextView) this.mRootView.findViewById(a.g.choose_bottom_tip);
        this.fcH.setText(a.i.sdk_choose_custom_number_tip);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.b.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < c.this.fdc.size()) {
                    c.this.fdb = (e) c.this.fdc.get(i);
                    if (c.this.fdb != null) {
                        c.this.fdh = c.this.fdb.getNumber();
                        c.this.fda.pD(c.this.fdh);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.b.d
    public void e(TextView textView) {
        textView.setText(a.i.sdk_choose_number_title);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        super.e(alaLiveInputEditView);
        alaLiveInputEditView.setHintText(this.mContext.getResources().getString(a.i.sdk_choose_input_num_hint));
    }

    @Override // com.baidu.tieba.ala.b.d
    public void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        d(alaSdkGetGiftListHttpResponseMessage);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void ay(int i, String str) {
        d(null);
    }

    private void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        if (alaSdkGetGiftListHttpResponseMessage != null) {
            this.fdc = alaSdkGetGiftListHttpResponseMessage.zg();
        }
        if (ListUtils.isEmpty(this.fdc)) {
            bnv();
        }
        if (this.fdh > 0) {
            Iterator<e> it = this.fdc.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e next = it.next();
                if (next != null && this.fdh == next.getNumber()) {
                    this.fdb = next;
                    break;
                }
            }
        }
        this.fda = new a(this.fde.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.fda);
        this.fda.setGiftNum(this.fdh);
        this.fda.setData(this.fdc);
    }

    private void bnv() {
        this.fdc = new ArrayList<>();
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
            this.fdc.add(eVar);
        }
    }

    @Override // com.baidu.tieba.ala.b.d
    public void confirm() {
        if (this.fdb != null) {
            g(this.fdb.number, this.fdb.name, false);
        } else {
            this.fde.finish();
        }
    }

    @Override // com.baidu.tieba.ala.b.d
    public void pA(int i) {
        super.pA(i);
        g(i, "", true);
    }

    @Override // com.baidu.tieba.ala.b.d
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        super.a(charSequence, i, i2, i3);
        if (JavaTypesHelper.toInt(charSequence.toString(), 0) > 9999) {
            this.eHj.getEditView().setText("9999");
            this.eHj.getEditView().setSelection(this.eHj.getEditView().getText().length());
        }
        this.eHj.setSendEnabled(true);
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
        this.fde.setResult(-1, intent);
        this.fde.finish();
    }

    @Override // com.baidu.tieba.ala.b.d
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

        public void pD(int i) {
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
        /* renamed from: bM */
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
                bVar2.fcO = (RelativeLayout) view.findViewById(a.g.item_root);
                bVar2.fcP = (TextView) view.findViewById(a.g.item_num_title);
                bVar2.fcQ = (ImageView) view.findViewById(a.g.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            e item = getItem(i);
            if (item != null) {
                bVar.fcP.setText(item.getNumber() + " " + item.getName());
                if (item.getNumber() == this.mGiftNum) {
                    bVar.fcQ.setVisibility(0);
                } else {
                    bVar.fcQ.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        public RelativeLayout fcO;
        public TextView fcP;
        public ImageView fcQ;

        private b() {
        }
    }
}
