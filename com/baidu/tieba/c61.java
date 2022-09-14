package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public final class c61 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] AdImageView;
    public static final int AdImageView_adCornerRadius = 0;
    public static final int AdImageView_borderColor = 1;
    public static final int AdImageView_borderColorWidth = 2;
    public static final int AdImageView_circleType = 3;
    public static final int AdImageView_errorHolder = 4;
    public static final int AdImageView_holder = 5;
    public static final int AdImageView_imageScaleType = 6;
    public static final int AdImageView_leftBottomRadius = 7;
    public static final int AdImageView_leftTopRadius = 8;
    public static final int AdImageView_loadingHolder = 9;
    public static final int AdImageView_rightBottomRadius = 10;
    public static final int AdImageView_rightTopRadius = 11;
    public static final int[] ExpandIconView;
    public static final int ExpandIconView_animationDuration = 0;
    public static final int ExpandIconView_color = 1;
    public static final int ExpandIconView_length = 2;
    public static final int ExpandIconView_thick = 3;
    public static final int[] NADUnifyTextView;
    public static final int NADUnifyTextView_spannable_bottom_padding = 0;
    public static final int NADUnifyTextView_spannable_top_padding = 1;
    public static final int[] NadBdThumbSeekBar;
    public static final int NadBdThumbSeekBar_nad_ThumbSeekBarStyle = 0;
    public static final int[] NadEnhanceButtonView;
    public static final int NadEnhanceButtonView_btnBackgroundEndColor = 0;
    public static final int NadEnhanceButtonView_btnBackgroundStartColor = 1;
    public static final int NadEnhanceButtonView_btnCornerRadius = 2;
    public static final int[] NadRoundProgressBar;
    public static final int NadRoundProgressBar_max = 0;
    public static final int NadRoundProgressBar_nad_style = 1;
    public static final int NadRoundProgressBar_reverse = 2;
    public static final int NadRoundProgressBar_roundColor = 3;
    public static final int NadRoundProgressBar_roundHintTextSize = 4;
    public static final int NadRoundProgressBar_roundMax = 5;
    public static final int NadRoundProgressBar_roundPaintCapRound = 6;
    public static final int NadRoundProgressBar_roundProgressColor = 7;
    public static final int NadRoundProgressBar_roundTextColor = 8;
    public static final int NadRoundProgressBar_roundTextSize = 9;
    public static final int NadRoundProgressBar_roundWidth = 10;
    public static final int NadRoundProgressBar_textColor = 11;
    public static final int NadRoundProgressBar_textIsDisplayable = 12;
    public static final int NadRoundProgressBar_textSize = 13;
    public static final int[] NadShadowViewGroup;
    public static final int NadShadowViewGroup_containerCornerRadius = 0;
    public static final int NadShadowViewGroup_containerDeltaHeight = 1;
    public static final int NadShadowViewGroup_containerDeltaWidth = 2;
    public static final int NadShadowViewGroup_containerShadowColor = 3;
    public static final int NadShadowViewGroup_containerShadowRadius = 4;
    public static final int NadShadowViewGroup_deltaX = 5;
    public static final int NadShadowViewGroup_deltaY = 6;
    public static final int NadShadowViewGroup_enable = 7;
    public static final int NadShadowViewGroup_shadowAlpha = 8;
    public static final int[] NadTextProgressView;
    public static final int NadTextProgressView_nad_progressGravity = 0;
    public static final int NadTextProgressView_nad_progressTextColor = 1;
    public static final int NadTextProgressView_nad_progressTextMode = 2;
    public static final int NadTextProgressView_nad_progressTextSize = 3;
    public static final int[] RoundCornerRelativeLayout;
    public static final int RoundCornerRelativeLayout_round_edge_radius = 0;
    public static final int[] SimpleAdInfoView;
    public static final int SimpleAdInfoView_layoutId = 0;
    public static final int[] nad_bdvideoplayer_bdPlayerProgressView;
    public static final int nad_bdvideoplayer_bdPlayerProgressView_nad_bdvideoplayer_progressGravity = 0;
    public static final int nad_bdvideoplayer_bdPlayerProgressView_nad_bdvideoplayer_progressTextColor = 1;
    public static final int nad_bdvideoplayer_bdPlayerProgressView_nad_bdvideoplayer_progressTextMode = 2;
    public static final int nad_bdvideoplayer_bdPlayerProgressView_nad_bdvideoplayer_progressTextSize = 3;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947626603, "Lcom/baidu/tieba/c61;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947626603, "Lcom/baidu/tieba/c61;");
                return;
            }
        }
        AdImageView = new int[]{R.attr.obfuscated_res_0x7f040071, R.attr.obfuscated_res_0x7f0400e9, R.attr.obfuscated_res_0x7f0400ea, R.attr.obfuscated_res_0x7f040152, R.attr.obfuscated_res_0x7f04028b, R.attr.obfuscated_res_0x7f040322, R.attr.obfuscated_res_0x7f040338, R.attr.obfuscated_res_0x7f040421, R.attr.obfuscated_res_0x7f040427, R.attr.obfuscated_res_0x7f040496, R.attr.obfuscated_res_0x7f0405c0, R.attr.obfuscated_res_0x7f0405c5};
        ExpandIconView = new int[]{R.attr.animationDuration, R.attr.obfuscated_res_0x7f04016a, R.attr.obfuscated_res_0x7f040429, R.attr.obfuscated_res_0x7f0406fa};
        NADUnifyTextView = new int[]{R.attr.spannable_bottom_padding, R.attr.spannable_top_padding};
        NadBdThumbSeekBar = new int[]{R.attr.obfuscated_res_0x7f0404e3};
        NadEnhanceButtonView = new int[]{R.attr.obfuscated_res_0x7f04010c, R.attr.obfuscated_res_0x7f04010d, R.attr.obfuscated_res_0x7f04010f};
        NadRoundProgressBar = new int[]{R.attr.obfuscated_res_0x7f0404b9, R.attr.obfuscated_res_0x7f0404f9, R.attr.obfuscated_res_0x7f0405bc, R.attr.obfuscated_res_0x7f0405cd, R.attr.obfuscated_res_0x7f0405ce, R.attr.obfuscated_res_0x7f0405cf, R.attr.obfuscated_res_0x7f0405d0, R.attr.roundProgressColor, R.attr.obfuscated_res_0x7f0405d4, R.attr.obfuscated_res_0x7f0405d6, R.attr.obfuscated_res_0x7f0405d7, R.attr.obfuscated_res_0x7f0406e4, R.attr.textIsDisplayable, R.attr.obfuscated_res_0x7f0406f1};
        NadShadowViewGroup = new int[]{R.attr.obfuscated_res_0x7f04018c, R.attr.obfuscated_res_0x7f04018d, R.attr.obfuscated_res_0x7f04018e, R.attr.obfuscated_res_0x7f04018f, R.attr.obfuscated_res_0x7f040190, R.attr.obfuscated_res_0x7f04020b, R.attr.obfuscated_res_0x7f04020c, R.attr.obfuscated_res_0x7f040272, R.attr.obfuscated_res_0x7f040612};
        NadTextProgressView = new int[]{R.attr.obfuscated_res_0x7f0404f5, R.attr.obfuscated_res_0x7f0404f6, R.attr.obfuscated_res_0x7f0404f7, R.attr.obfuscated_res_0x7f0404f8};
        RoundCornerRelativeLayout = new int[]{R.attr.obfuscated_res_0x7f0405d9};
        SimpleAdInfoView = new int[]{R.attr.obfuscated_res_0x7f04040b};
        nad_bdvideoplayer_bdPlayerProgressView = new int[]{R.attr.obfuscated_res_0x7f0404e4, R.attr.obfuscated_res_0x7f0404e5, R.attr.obfuscated_res_0x7f0404e6, R.attr.obfuscated_res_0x7f0404e7};
    }
}
