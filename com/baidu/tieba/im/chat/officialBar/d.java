package com.baidu.tieba.im.chat.officialBar;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes26.dex */
public class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> ajO = new ArrayList<>();
    private c kmp;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes26.dex */
    public interface c {
        void a(View view, Object obj, int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbPageContext<?> tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.kmp = cVar;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.ajO.clear();
            this.ajO.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.ajO != null && this.ajO.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.ajO.get(i);
            if ((viewHolder instanceof b) && (aVar instanceof a)) {
                ((b) viewHolder).b(aVar);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.ajO == null) {
            return 0;
        }
        return this.ajO.size();
    }

    /* loaded from: classes26.dex */
    class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView jAy;
        private BarImageView kmr;
        private View kms;
        private a kmt;

        b(View view) {
            super(view);
            this.kmr = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.jAy = (TextView) view.findViewById(R.id.official_bar_name);
            this.kms = view.findViewById(R.id.official_bar_feed_red_dot);
            this.kmr.setShowOval(true);
            this.kmr.setPlaceHolder(2);
            this.kmr.setShowOuterBorder(false);
            this.kmr.setShowInnerBorder(true);
            this.kmr.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        void b(com.baidu.tbadk.mvc.b.a aVar) {
            this.kmt = (a) aVar;
            ap.setViewTextColor(this.jAy, R.color.CAM_X0105);
            ap.setBackgroundResource(this.kms, R.drawable.icon_official_bar_red_dot);
            this.kmr.setStrokeColorResId(R.color.CAM_X0401);
            this.kmr.startLoad(this.kmt.cTY(), 10, false);
            if (au.getChineseAndEnglishLength(this.kmt.cNV()) <= 10) {
                this.jAy.setText(this.kmt.cNV());
            } else {
                this.jAy.setText(au.cutChineseAndEnglishWithSuffix(this.kmt.cNV(), 8, StringHelper.STRING_MORE));
            }
            this.kmr.setOnClickListener(this);
            if (this.kmt.getUnReadCount() > 0 && (this.kmt.cTZ() <= 0 || System.currentTimeMillis() - this.kmt.cTZ() < 864000000)) {
                this.kms.setVisibility(0);
            } else {
                this.kms.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.kms.setVisibility(8);
            if (d.this.kmp != null) {
                d.this.kmp.a(view, this.kmt, getAdapterPosition(), getItemId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public static class a implements com.baidu.tbadk.mvc.b.a {
        private long cWM;
        private long groupId;
        private String jLy;
        private String kmq;
        private int unReadCount;
        private int userType;

        String cTY() {
            return this.kmq;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String cNV() {
            return this.jLy;
        }

        int getUnReadCount() {
            return this.unReadCount;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void MM(String str) {
            this.kmq = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void MN(String str) {
            this.jLy = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setUnReadCount(int i) {
            this.unReadCount = i;
        }

        public void setGroupId(long j) {
            this.groupId = j;
        }

        public void setUserType(int i) {
            this.userType = i;
        }

        public long getGroupId() {
            return this.groupId;
        }

        public long cTZ() {
            return this.cWM;
        }

        public void gM(long j) {
            this.cWM = j;
        }
    }
}
