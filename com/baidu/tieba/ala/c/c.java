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
import com.baidu.live.data.j;
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
    private RelativeLayout gGc;
    private TextView gGd;
    private a gGw;
    private j gGx;
    private ArrayList<j> gGy;
    private BdListView mListView;

    public c(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
    }

    @Override // com.baidu.tieba.ala.c.d
    protected int bUz() {
        return a.g.ala_choose_num_and_date;
    }

    @Override // com.baidu.tieba.ala.c.d
    protected void initView() {
        this.gGc = (RelativeLayout) this.mRootView.findViewById(a.f.choose_bottom_layout);
        this.gGc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bOV();
            }
        });
        this.gGd = (TextView) this.mRootView.findViewById(a.f.choose_bottom_tip);
        this.gGd.setText(a.h.sdk_choose_custom_number_tip);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < c.this.gGy.size()) {
                    c.this.gGx = (j) c.this.gGy.get(i);
                    if (c.this.gGx != null) {
                        c.this.gGC = c.this.gGx.getNumber();
                        c.this.gGw.vF(c.this.gGC);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.c.d
    public void j(TextView textView) {
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
    public void aT(int i, String str) {
        e((AlaSdkGetGiftListHttpResponseMessage) null);
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        if (alaSdkGetGiftListHttpResponseMessage != null) {
            this.gGy = alaSdkGetGiftListHttpResponseMessage.KH();
        }
        if (ListUtils.isEmpty(this.gGy)) {
            bUA();
        }
        if (this.gGC > 0) {
            Iterator<j> it = this.gGy.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                j next = it.next();
                if (next != null && this.gGC == next.getNumber()) {
                    this.gGx = next;
                    break;
                }
            }
        }
        this.gGw = new a(this.gGA.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.gGw);
        this.gGw.setGiftNum(this.gGC);
        this.gGw.setData(this.gGy);
    }

    private void bUA() {
        this.gGy = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            j jVar = new j();
            switch (i) {
                case 0:
                    jVar.number = 1;
                    jVar.name = "一心一意";
                    break;
                case 1:
                    jVar.number = 10;
                    jVar.name = "十全十美";
                    break;
                case 2:
                    jVar.number = 66;
                    jVar.name = "六六大顺";
                    break;
                case 3:
                    jVar.number = Opcodes.NEWARRAY;
                    jVar.name = "要抱抱";
                    break;
                case 4:
                    jVar.number = 520;
                    jVar.name = "我爱你";
                    break;
                case 5:
                    jVar.number = ResponseCode.MCASAT_SEND_MSG_COLSE_ROOM;
                    jVar.name = "一生一世";
                    break;
            }
            this.gGy.add(jVar);
        }
    }

    @Override // com.baidu.tieba.ala.c.d
    public void confirm() {
        if (this.gGx != null) {
            i(this.gGx.number, this.gGx.name, false);
        } else {
            this.gGA.finish();
        }
    }

    @Override // com.baidu.tieba.ala.c.d
    public void vC(int i) {
        super.vC(i);
        i(i, "", true);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        super.a(charSequence, i, i2, i3);
        if (JavaTypesHelper.toInt(charSequence.toString(), 0) > 9999) {
            this.gfT.getEditView().setText("9999");
            this.gfT.getEditView().setSelection(this.gfT.getEditView().getText().length());
        }
        this.gfT.setSendEnabled(true);
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
        this.gGA.setResult(-1, intent);
        this.gGA.finish();
    }

    @Override // com.baidu.tieba.ala.c.d
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        private List<j> dataList;
        private Context mContext;
        private int mGiftNum;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void setGiftNum(int i) {
            this.mGiftNum = i;
        }

        public void vF(int i) {
            if (this.mGiftNum != i) {
                this.mGiftNum = i;
                notifyDataSetChanged();
            }
        }

        public void setData(List<j> list) {
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
        /* renamed from: ew */
        public j getItem(int i) {
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
                bVar2.gGk = (RelativeLayout) view.findViewById(a.f.item_root);
                bVar2.gGl = (TextView) view.findViewById(a.f.item_num_title);
                bVar2.gGm = (ImageView) view.findViewById(a.f.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            j item = getItem(i);
            if (item != null) {
                bVar.gGl.setText(item.getNumber() + " " + item.getName());
                if (item.getNumber() == this.mGiftNum) {
                    bVar.gGm.setVisibility(0);
                } else {
                    bVar.gGm.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        public RelativeLayout gGk;
        public TextView gGl;
        public ImageView gGm;

        private b() {
        }
    }
}
