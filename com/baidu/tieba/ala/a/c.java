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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.r.a;
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
/* loaded from: classes2.dex */
public class c extends d {
    private a etF;
    private com.baidu.live.data.d etG;
    private ArrayList<com.baidu.live.data.d> etH;
    private RelativeLayout etl;
    private TextView etm;
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
        this.etl = (RelativeLayout) this.mRootView.findViewById(a.g.choose_bottom_layout);
        this.etl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aZh();
            }
        });
        this.etm = (TextView) this.mRootView.findViewById(a.g.choose_bottom_tip);
        this.etm.setText(a.i.sdk_choose_custom_number_tip);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.a.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < c.this.etH.size()) {
                    c.this.etG = (com.baidu.live.data.d) c.this.etH.get(i);
                    if (c.this.etG != null) {
                        c.this.etM = c.this.etG.getNumber();
                        c.this.etF.oP(c.this.etM);
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
    public void ai(int i, String str) {
        d((AlaSdkGetGiftListHttpResponseMessage) null);
    }

    private void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        if (alaSdkGetGiftListHttpResponseMessage != null) {
            this.etH = alaSdkGetGiftListHttpResponseMessage.tq();
        }
        if (ListUtils.isEmpty(this.etH)) {
            bbK();
        }
        if (this.etM > 0) {
            Iterator<com.baidu.live.data.d> it = this.etH.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.live.data.d next = it.next();
                if (next != null && this.etM == next.getNumber()) {
                    this.etG = next;
                    break;
                }
            }
        }
        this.etF = new a(this.etJ.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.etF);
        this.etF.setGiftNum(this.etM);
        this.etF.setData(this.etH);
    }

    private void bbK() {
        this.etH = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            com.baidu.live.data.d dVar = new com.baidu.live.data.d();
            switch (i) {
                case 0:
                    dVar.number = 1;
                    dVar.name = "一心一意";
                    break;
                case 1:
                    dVar.number = 10;
                    dVar.name = "十全十美";
                    break;
                case 2:
                    dVar.number = 66;
                    dVar.name = "六六大顺";
                    break;
                case 3:
                    dVar.number = 188;
                    dVar.name = "要抱抱";
                    break;
                case 4:
                    dVar.number = UIMsg.m_AppUI.MSG_PLACEFIELD_RELOAD;
                    dVar.name = "我爱你";
                    break;
                case 5:
                    dVar.number = 1314;
                    dVar.name = "一生一世";
                    break;
            }
            this.etH.add(dVar);
        }
    }

    @Override // com.baidu.tieba.ala.a.d
    public void confirm() {
        if (this.etG != null) {
            f(this.etG.number, this.etG.name, false);
        } else {
            this.etJ.finish();
        }
    }

    @Override // com.baidu.tieba.ala.a.d
    public void oM(int i) {
        super.oM(i);
        f(i, "", true);
    }

    @Override // com.baidu.tieba.ala.a.d
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        super.a(charSequence, i, i2, i3);
        if (JavaTypesHelper.toInt(charSequence.toString(), 0) > 9999) {
            this.ecH.getEditView().setText("9999");
            this.ecH.getEditView().setSelection(this.ecH.getEditView().getText().length());
        }
        this.ecH.setSendEnabled(true);
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
        this.etJ.setResult(-1, intent);
        this.etJ.finish();
    }

    @Override // com.baidu.tieba.ala.a.d
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        private List<com.baidu.live.data.d> dataList;
        private Context mContext;
        private int mGiftNum;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void setGiftNum(int i) {
            this.mGiftNum = i;
        }

        public void oP(int i) {
            if (this.mGiftNum != i) {
                this.mGiftNum = i;
                notifyDataSetChanged();
            }
        }

        public void setData(List<com.baidu.live.data.d> list) {
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
        /* renamed from: bs */
        public com.baidu.live.data.d getItem(int i) {
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
                bVar2.ett = (RelativeLayout) view.findViewById(a.g.item_root);
                bVar2.etu = (TextView) view.findViewById(a.g.item_num_title);
                bVar2.etv = (ImageView) view.findViewById(a.g.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            com.baidu.live.data.d item = getItem(i);
            if (item != null) {
                bVar.etu.setText(item.getNumber() + HanziToPinyin.Token.SEPARATOR + item.getName());
                if (item.getNumber() == this.mGiftNum) {
                    bVar.etv.setVisibility(0);
                } else {
                    bVar.etv.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        public RelativeLayout ett;
        public TextView etu;
        public ImageView etv;

        private b() {
        }
    }
}
