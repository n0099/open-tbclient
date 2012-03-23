package com.baidu.tieba.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SearchAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> mData;
    private String mForum;

    public SearchAdapter(Context context, ArrayList<String> data) {
        this.mContext = context;
        this.mData = data;
        this.mForum = this.mContext.getText(R.string.forum).toString();
    }

    public void setData(ArrayList<String> data) {
        this.mData = data;
    }

    public ArrayList<String> getData() {
        return this.mData;
    }

    public void adjust(int index) {
        String name = this.mData.get(index);
        this.mData.remove(index);
        this.mData.add(0, name);
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
        ViewHolder holder;
        Object obData;
        try {
            if (convertView == null) {
                LayoutInflater mInflater = LayoutInflater.from(this.mContext);
                convertView = mInflater.inflate(R.layout.home_dialog_search_item, (ViewGroup) null);
                ViewHolder holder2 = new ViewHolder(this, null);
                try {
                    holder2.mForumName = (TextView) convertView.findViewById(R.id.home_lv_search_forum);
                    convertView.setTag(holder2);
                    holder = holder2;
                } catch (Exception e) {
                    ex = e;
                    TiebaLog.e(getClass().getName(), "", "PbAdapter.getView error = " + ex.getMessage());
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
        String data = (String) obData;
        holder.mForumName.setText(data.concat(this.mForum));
        return convertView;
    }

    /* loaded from: classes.dex */
    private class ViewHolder {
        TextView mForumName;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(SearchAdapter searchAdapter, ViewHolder viewHolder) {
            this();
        }
    }
}
