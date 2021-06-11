package com.baidu.tieba.barselect;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import d.a.n0.x.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class CandidateSearchAdapter extends RecyclerView.Adapter<CandidateSearchItemHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f14156a = new ArrayList();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(CandidateSearchItemHolder candidateSearchItemHolder, int i2) {
        if (candidateSearchItemHolder == null || ListUtils.isEmpty(this.f14156a)) {
            return;
        }
        candidateSearchItemHolder.g(this.f14156a.get(i2));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public CandidateSearchItemHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new CandidateSearchItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_candidate_item, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f14156a.size();
    }

    public void setData(List<a> list) {
        this.f14156a.clear();
        this.f14156a.addAll(list);
        notifyDataSetChanged();
    }
}
