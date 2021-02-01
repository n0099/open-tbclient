package com.baidu.tieba.ala.alasquare.liveroomlivetab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.b;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class NormalSkinPbListView extends b {
    private ImageView lineView;
    private LinearLayout mContainer;
    private Context mContext;
    private View mEmpty;
    private boolean mIsMoreViewVisible;
    private View.OnClickListener mOnClickListener;
    private ProgressBar mProgressBar;
    private View mRoot;
    private TextView mTextView;
    private LinearLayout mTopExtraView;

    /* loaded from: classes10.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mRoot = LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
        this.mContainer = (LinearLayout) this.mRoot.findViewById(R.id.pb_more_view);
        this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
        if (this.mIsMoreViewVisible) {
            this.mContainer.setVisibility(0);
        } else {
            this.mContainer.setVisibility(8);
        }
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.lineView = (ImageView) this.mRoot.findViewById(R.id.pb_more_view_top_line);
        this.mEmpty = this.mRoot.findViewById(R.id.empty_view);
        this.mTopExtraView = (LinearLayout) this.mRoot.findViewById(R.id.pb_more_top_extra_view);
        return this.mRoot;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
