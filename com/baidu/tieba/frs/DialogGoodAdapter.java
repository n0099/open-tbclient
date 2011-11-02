package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.data.GoodData;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DialogGoodAdapter extends BaseAdapter {
    private String mAllGoodClass;
    private String mAllThreadClass;
    private Context mContext;
    private ArrayList<GoodData> mData;
    public static int FRS_ALLTHREAD_CLASS_ID = -1;
    public static int FRS_ALLGOOD_CLASS_ID = 0;

    public DialogGoodAdapter(Context context, ArrayList<GoodData> data) {
        this.mContext = context;
        this.mData = data;
        this.mAllThreadClass = this.mContext.getText(R.string.frs_all).toString();
        this.mAllGoodClass = this.mContext.getText(R.string.frs_good).toString();
        processData();
    }

    public void setData(ArrayList<GoodData> data) {
        this.mData = data;
        processData();
    }

    public ArrayList<GoodData> getData() {
        return this.mData;
    }

    private void processData() {
        if (this.mData != null) {
            ArrayList<GoodData> newGood = new ArrayList<>();
            GoodData dAll = new GoodData();
            dAll.setClass_id(FRS_ALLTHREAD_CLASS_ID);
            dAll.setClass_name(this.mAllThreadClass);
            GoodData dGood = new GoodData();
            dGood.setClass_id(FRS_ALLGOOD_CLASS_ID);
            dGood.setClass_name(this.mAllGoodClass);
            newGood.add(dAll);
            newGood.add(dGood);
            if (this.mData != null && this.mData.size() > 0) {
                for (int i = 0; i < this.mData.size(); i++) {
                    GoodData g = this.mData.get(i);
                    if (g.getClass_id() != FRS_ALLGOOD_CLASS_ID) {
                        newGood.add(g);
                    }
                }
            }
            this.mData = newGood;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        int count = getCount();
        if (count <= 0 || position >= count) {
            return null;
        }
        Object item = this.mData.get(position);
        return item;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Exception ex;
        ViewHolder holder;
        Object obData;
        try {
            if (convertView == null) {
                LayoutInflater mInflater = LayoutInflater.from(this.mContext);
                convertView = mInflater.inflate(R.layout.dialog_good_item, (ViewGroup) null);
                ViewHolder holder2 = new ViewHolder();
                try {
                    holder2.mText = (TextView) convertView.findViewById(R.id.frs_dia_good_text);
                    convertView.setTag(holder2);
                    holder = holder2;
                } catch (Exception e) {
                    ex = e;
                    TiebaLog.e(getClass().getName(), "", "DialogGoodAdapter.getView error = " + ex.getMessage());
                    return convertView;
                }
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            obData = getItem(position);
        } catch (Exception e2) {
            ex = e2;
        }
        if (obData == null) {
            return convertView;
        }
        GoodData data = (GoodData) obData;
        holder.mText.setText(data.getClass_name());
        return convertView;
    }

    /* loaded from: classes.dex */
    private class ViewHolder {
        TextView mText;

        private ViewHolder() {
        }
    }
}
