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
import com.baidu.live.data.l;
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
/* loaded from: classes11.dex */
public class c extends d {
    private RelativeLayout gQb;
    private TextView gQc;
    private a gQv;
    private l gQw;
    private ArrayList<l> gQx;
    private BdListView mListView;

    public c(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        super(alaChooseGiftActivity, frameLayout, str, arrayList, i, i2);
    }

    @Override // com.baidu.tieba.ala.c.d
    protected int bTX() {
        return a.g.ala_choose_num_and_date;
    }

    @Override // com.baidu.tieba.ala.c.d
    protected void initView() {
        this.gQb = (RelativeLayout) this.mRootView.findViewById(a.f.choose_bottom_layout);
        this.gQb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bOm();
            }
        });
        this.gQc = (TextView) this.mRootView.findViewById(a.f.choose_bottom_tip);
        this.gQc.setText(a.h.sdk_choose_custom_number_tip);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.choose_gift_listview);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.c.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0 && i < c.this.gQx.size()) {
                    c.this.gQw = (l) c.this.gQx.get(i);
                    if (c.this.gQw != null) {
                        c.this.gQB = c.this.gQw.getNumber();
                        c.this.gQv.uq(c.this.gQB);
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
    public void bb(int i, String str) {
        e((AlaSdkGetGiftListHttpResponseMessage) null);
    }

    private void e(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        if (alaSdkGetGiftListHttpResponseMessage != null) {
            this.gQx = alaSdkGetGiftListHttpResponseMessage.HD();
        }
        if (ListUtils.isEmpty(this.gQx)) {
            bTY();
        }
        if (this.gQB > 0) {
            Iterator<l> it = this.gQx.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                l next = it.next();
                if (next != null && this.gQB == next.getNumber()) {
                    this.gQw = next;
                    break;
                }
            }
        }
        this.gQv = new a(this.gQz.getPageContext());
        this.mListView.setAdapter((ListAdapter) this.gQv);
        this.gQv.setGiftNum(this.gQB);
        this.gQv.setData(this.gQx);
    }

    private void bTY() {
        this.gQx = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            l lVar = new l();
            switch (i) {
                case 0:
                    lVar.number = 1;
                    lVar.name = "一心一意";
                    break;
                case 1:
                    lVar.number = 10;
                    lVar.name = "十全十美";
                    break;
                case 2:
                    lVar.number = 66;
                    lVar.name = "六六大顺";
                    break;
                case 3:
                    lVar.number = Opcodes.NEWARRAY;
                    lVar.name = "要抱抱";
                    break;
                case 4:
                    lVar.number = UIMsg.m_AppUI.MSG_PLACEFIELD_RELOAD;
                    lVar.name = "我爱你";
                    break;
                case 5:
                    lVar.number = ResponseCode.MCASAT_SEND_MSG_COLSE_ROOM;
                    lVar.name = "一生一世";
                    break;
            }
            this.gQx.add(lVar);
        }
    }

    @Override // com.baidu.tieba.ala.c.d
    public void confirm() {
        if (this.gQw != null) {
            h(this.gQw.number, this.gQw.name, false);
        } else {
            this.gQz.finish();
        }
    }

    @Override // com.baidu.tieba.ala.c.d
    public void un(int i) {
        super.un(i);
        h(i, "", true);
    }

    @Override // com.baidu.tieba.ala.c.d
    public void a(CharSequence charSequence, int i, int i2, int i3) {
        super.a(charSequence, i, i2, i3);
        if (JavaTypesHelper.toInt(charSequence.toString(), 0) > 9999) {
            this.gok.getEditView().setText("9999");
            this.gok.getEditView().setSelection(this.gok.getEditView().getText().length());
        }
        this.gok.setSendEnabled(true);
    }

    private void h(int i, String str, boolean z) {
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
        this.gQz.setResult(-1, intent);
        this.gQz.finish();
    }

    @Override // com.baidu.tieba.ala.c.d
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BaseAdapter {
        private List<l> dataList;
        private Context mContext;
        private int mGiftNum;

        public a(TbPageContext tbPageContext) {
            this.mContext = tbPageContext.getPageActivity();
        }

        public void setGiftNum(int i) {
            this.mGiftNum = i;
        }

        public void uq(int i) {
            if (this.mGiftNum != i) {
                this.mGiftNum = i;
                notifyDataSetChanged();
            }
        }

        public void setData(List<l> list) {
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
        /* renamed from: cT */
        public l getItem(int i) {
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
                bVar2.gQj = (RelativeLayout) view.findViewById(a.f.item_root);
                bVar2.gQk = (TextView) view.findViewById(a.f.item_num_title);
                bVar2.gQl = (ImageView) view.findViewById(a.f.item_num_arrow);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            l item = getItem(i);
            if (item != null) {
                bVar.gQk.setText(item.getNumber() + " " + item.getName());
                if (item.getNumber() == this.mGiftNum) {
                    bVar.gQl.setVisibility(0);
                } else {
                    bVar.gQl.setVisibility(8);
                }
            }
            return view;
        }
    }

    /* loaded from: classes11.dex */
    private class b {
        public RelativeLayout gQj;
        public TextView gQk;
        public ImageView gQl;

        private b() {
        }
    }
}
