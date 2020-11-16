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
    private a gxF;
    private j gxG;
    private ArrayList<j> gxH;
    private RelativeLayout gxl;
    private TextView gxm;
    private BdListView mListView;

    public c(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
    }

    @Override // com.baidu.tieba.ala.c.d
    protected int bQO() {
        return a.g.ala_choose_num_and_date;
    }

    @Override // com.baidu.tieba.ala.c.d
    protected void initView() {
        this.gxl = (RelativeLayout) this.mRootView.findViewById(a.f.choose_bottom_layout);
        this.gxl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bLl();
            }
        });
        this.gxm = (TextView) this.mRootView.findViewById(a.f.choose_bottom_tip);
        this.gxm.setText(a.h.sdk_choose_custom_number_tip);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < c.this.gxH.size()) {
                    c.this.gxG = (j) c.this.gxH.get(i);
                    if (c.this.gxG != null) {
                        c.this.gxL = c.this.gxG.getNumber();
                        c.this.gxF.uY(c.this.gxL);
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
            this.gxH = alaSdkGetGiftListHttpResponseMessage.IH();
        }
        if (ListUtils.isEmpty(this.gxH)) {
            bQP();
        }
        if (this.gxL > 0) {
            Iterator<j> it = this.gxH.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                j next = it.next();
                if (next != null && this.gxL == next.getNumber()) {
                    this.gxG = next;
                    break;
                }
            }
        }
        this.gxF = new a(this.gxJ.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.gxF);
        this.gxF.setGiftNum(this.gxL);
        this.gxF.setData(this.gxH);
    }

    private void bQP() {
        this.gxH = new ArrayList<>();
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
            this.gxH.add(jVar);
        }
    }

    @Override // com.baidu.tieba.ala.c.d
    public void confirm() {
        if (this.gxG != null) {
            i(this.gxG.number, this.gxG.name, false);
        } else {
            this.gxJ.finish();
        }
    }

    @Override // com.baidu.tieba.ala.c.d
    public void uV(int i) {
        super.uV(i);
        i(i, "", true);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        super.a(charSequence, i, i2, i3);
        if (JavaTypesHelper.toInt(charSequence.toString(), 0) > 9999) {
            this.fXG.getEditView().setText("9999");
            this.fXG.getEditView().setSelection(this.fXG.getEditView().getText().length());
        }
        this.fXG.setSendEnabled(true);
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
        this.gxJ.setResult(-1, intent);
        this.gxJ.finish();
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

        public void uY(int i) {
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
        /* renamed from: ec */
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
                bVar2.gxt = (RelativeLayout) view.findViewById(a.f.item_root);
                bVar2.gxu = (TextView) view.findViewById(a.f.item_num_title);
                bVar2.gxv = (ImageView) view.findViewById(a.f.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            j item = getItem(i);
            if (item != null) {
                bVar.gxu.setText(item.getNumber() + " " + item.getName());
                if (item.getNumber() == this.mGiftNum) {
                    bVar.gxv.setVisibility(0);
                } else {
                    bVar.gxv.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        public RelativeLayout gxt;
        public TextView gxu;
        public ImageView gxv;

        private b() {
        }
    }
}
